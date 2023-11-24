package lol.calico.uctutors

import android.util.Base64
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.coroutines.binding.binding
import com.github.michaelbull.result.getOr
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.state.RegisterData
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.generated.api.v1.LoginStatus
import lol.calico.uctutors.generated.api.v1.loginRequest
import lol.calico.uctutors.util.expect
import java.security.SecureRandom
import kotlin.coroutines.coroutineContext

class AccountHandler(private val activity: ComponentActivity, private val grpc: GrpcConnection) {
  companion object {
    const val TAG = "AccountHandler"
  }

  private val credentialManager = CredentialManager.create(activity)

  suspend fun tryImmediateSignIn(view: View): Result<LoginResponse?, Unit> = binding {
    val nonce = generateNonce()

    val googleIdOption = GetGoogleIdOption.Builder()
      .setFilterByAuthorizedAccounts(true)
      .setServerClientId(BuildConfig.WEB_CLIENT_ID)
      .setAutoSelectEnabled(true)
      .setNonce(nonce)
      .build()

    val getCredentialRequest = GetCredentialRequest(
      listOf(googleIdOption),
      preferImmediatelyAvailableCredentials = true
    )

    val result = expect {
      credentialManager.getCredential(
        context = activity,
        request = getCredentialRequest
      )
    }

    val loginResult = handleSignIn(view, result)

    return@binding loginResult.getOr(null)
  }

  suspend fun signIn(view: View): Result<LoginResponse, String> = binding {
    val nonce = generateNonce()

    val googleIdOption = GetGoogleIdOption.Builder()
      .setFilterByAuthorizedAccounts(false)
      .setServerClientId(BuildConfig.WEB_CLIENT_ID)
      .setAutoSelectEnabled(true)
      .setNonce(nonce)
      .build()

    val getCredentialRequest = GetCredentialRequest(
      listOf(googleIdOption)
    )

    val result = expect({ "Getting credentials failed: ${it.message}" }) {
      credentialManager.getCredential(
        context = activity,
        request = getCredentialRequest
      )
    }

    return@binding handleSignIn(view, result).bind()
  }

  private suspend fun handleSignIn(
    view: View,
    result: GetCredentialResponse,
  ): Result<LoginResponse, String> =
    binding {
      val credential = result.credential

      if (credential !is CustomCredential || credential.type != GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
        Log.e(TAG, "Unexpected type of credential")
        Err("Unexpected type of credential").bind<Unit>()
      }

      val googleIdTokenCredential =
        expect({ "Failed to create GoogleIdTokenCredential: ${it.message}" }) {
          GoogleIdTokenCredential.createFrom(credential.data)
        }

      val response = expect({ "Sign in failed: ${it.message}" }) {
        grpc.auth.login(loginRequest {
          idToken = googleIdTokenCredential.idToken
        })
      }

      Log.d(TAG, "response from server:$response")

      if (response.status == LoginStatus.LOGIN_STATUS_NEW_USER) {
        val sessionToken = response.newUser.token
        Log.d(TAG, "session token received from server:$sessionToken")

        Log.d(TAG, "new user, proceeding to registration")
        return@binding LoginResponse(LoginStatus.LOGIN_STATUS_NEW_USER, sessionToken)
      } else {
        val sessionToken = response.newUser.token
        TokenStorage(view.context).saveToken(sessionToken)
        Log.d(TAG, "session token received from server:$sessionToken")


        Log.d(TAG, "sign in success")
        return@binding LoginResponse(LoginStatus.LOGIN_STATUS_EXISTING_USER, sessionToken)
      }
    }

  private fun generateNonce(): String {
    val nonce = ByteArray(32)
    SecureRandom().nextBytes(nonce)
    return Base64.encodeToString(nonce, Base64.NO_WRAP)
  }

  data class LoginResponse(
    val status: LoginStatus,
    val token: String,
  )

  suspend fun signOut(view: View) {
    TokenStorage(view.context).clearToken()
    Log.d(TAG, coroutineContext.toString())
    try {
      // https://issuetracker.google.com/issues/311012734
      credentialManager.clearCredentialState(ClearCredentialStateRequest())
    } catch (e: Exception) {
      Log.e(TAG, "Failed to clear credential state: ${e.message}")
    }
  }

  suspend fun register(view: View, registerData: RegisterData): Result<Unit, String> = binding {
    Ok(Unit)
  }
}
