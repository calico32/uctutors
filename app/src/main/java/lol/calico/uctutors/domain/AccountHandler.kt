package lol.calico.uctutors.domain

import android.content.Context
import android.util.Log
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialCustomException
import androidx.credentials.exceptions.NoCredentialException
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.coroutines.binding.binding
import com.github.michaelbull.result.getOr
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.protobuf.empty
import dagger.hilt.android.qualifiers.ActivityContext
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.generated.api.v1.LoginStatus
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.loginRequest
import lol.calico.uctutors.generated.api.v1.registerRequest
import lol.calico.uctutors.util.expect
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext

@Singleton
class AccountHandler @Inject constructor(
  @ActivityContext private val context: Context,
  private val grpc: GrpcConnection,
  private val tokenStorage: TokenStorage,
) {
  companion object {
    const val TAG = "AccountHandler"
    const val NO_ACCOUNTS_AVAILABLE = "no_accounts_available"
  }

  private val credentialManager = CredentialManager.create(context)

  suspend fun tryImmediateSignIn(): Result<LoginResponse?, Unit> = binding {
    val nonce = generateNonce()

    val googleIdOption = GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(true)
      .setServerClientId(BuildConfig.WEB_CLIENT_ID).setAutoSelectEnabled(true).setNonce(nonce)
      .build()

    val getCredentialRequest = GetCredentialRequest(
      listOf(googleIdOption), preferImmediatelyAvailableCredentials = true
    )

    val result = expect {
      credentialManager.getCredential(
        context = context,
        request = getCredentialRequest
      )
    }

    val loginResult = handleSignIn(result)

    return@binding loginResult.getOr(null)
  }

  suspend fun signIn(): Result<LoginResponse, String> = binding {
    val nonce = generateNonce()

    Log.d(TAG, "nonce: $nonce")

    var googleIdOption = GetGoogleIdOption.Builder()
      .setFilterByAuthorizedAccounts(true)
      .setServerClientId(BuildConfig.WEB_CLIENT_ID)
      .setAutoSelectEnabled(false)
      .setNonce(nonce)
      .build()


    var getCredentialRequest = GetCredentialRequest.Builder()
      .addCredentialOption(googleIdOption)
      .build()

    var result = getCredential(getCredentialRequest)

    if (result is Err && result.error == NO_ACCOUNTS_AVAILABLE) {
      Log.d(TAG, "No accounts available, trying again with all accounts")

      val googleSignInOption = GetSignInWithGoogleOption.Builder(BuildConfig.WEB_CLIENT_ID)
        .setHostedDomainFilter("ucvts.org")
        .setNonce(nonce)
        .build()


      getCredentialRequest = GetCredentialRequest.Builder()
        .addCredentialOption(googleSignInOption)
        .build()

      result = getCredential(getCredentialRequest)
    }

    return@binding handleSignIn(result.bind()).bind()
  }

  private suspend fun getCredential(getCredentialRequest: GetCredentialRequest): Result<GetCredentialResponse, String> =
    binding {
      expect({
        when (it) {
          is GetCredentialCustomException -> {
            "Getting credential failed: ${it.type} ${it.message}"
          }

          is NoCredentialException -> {
            NO_ACCOUNTS_AVAILABLE
          }

          else -> {
            "Getting credential failed: ${it.javaClass.name} ${it.message}"
          }
        }
      }) {
        credentialManager.getCredential(
          context = context, request = getCredentialRequest
        )
      }
    }

  private suspend fun handleSignIn(
    result: GetCredentialResponse,
  ): Result<LoginResponse, String> = binding {
    val credential = result.credential

    if (credential !is CustomCredential || (
        credential.type != GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL
          && credential.type != GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        )
    ) {
      Log.e(TAG, "Unexpected type of credential")
      Err("Unexpected type of credential").bind<Unit>()
    }

    val googleIdTokenCredential =
      expect({ "Failed to create GoogleIdTokenCredential: ${it.message}" }) {
        GoogleIdTokenCredential.createFrom(credential.data)
      }

    Log.d(TAG, "googleIdTokenCredential: $googleIdTokenCredential")

    val response = expect({ "Sign in failed: ${it.message}" }) {
      grpc.auth.login(loginRequest {
        idToken = googleIdTokenCredential.idToken
      })
    }

    Log.d(TAG, "response from server:$response")

    if (response.status == LoginStatus.LOGIN_STATUS_NEW_USER) {
      val sessionToken = response.newUser.token
      Log.d(TAG, "new user, proceeding to registration")

      return@binding LoginResponse(LoginStatus.LOGIN_STATUS_NEW_USER, sessionToken)
    } else {
      val sessionToken = response.existingUser.token
      Log.d(TAG, "sign in success")

      return@binding LoginResponse(LoginStatus.LOGIN_STATUS_EXISTING_USER, sessionToken)
    }
  }

  private suspend fun generateNonce(): String {
    return grpc.auth.getNonce(empty {}).nonce
  }

  data class LoginResponse(
    val status: LoginStatus,
    val token: String,
  )

  suspend fun signOut() {
    tokenStorage.clearToken()
    Log.d(TAG, coroutineContext.toString())
    try {
      // https://issuetracker.google.com/issues/311012734
      credentialManager.clearCredentialState(ClearCredentialStateRequest())
    } catch (e: Exception) {
      Log.e(TAG, "Failed to clear credential state: ${e.message}")
    }
  }

  suspend fun register(registerData: RegisterData): Result<Unit, String> = binding {
    val response = expect({ "Registration failed: ${it.message}" }) {
      grpc.auth.register(registerRequest {
        data = registerData
      })
    }

    Log.d(TAG, "response from server:$response")

    return@binding
  }
}
