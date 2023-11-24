package lol.calico.uctutors

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException

class GoogleSignInContract : ActivityResultContract<Intent, Result<GoogleSignInAccount, String>>() {
  override fun createIntent(context: Context, input: Intent): Intent {
    return input
  }

  companion object {
    const val TAG = "GoogleSignInContract"
  }

  override fun parseResult(resultCode: Int, intent: Intent?): Result<GoogleSignInAccount, String> {
    if (resultCode != Activity.RESULT_OK) {
      return Err("Error: code $resultCode")
    }

    val task = GoogleSignIn.getSignedInAccountFromIntent(intent)

    return try {
      val account: GoogleSignInAccount = task.getResult(ApiException::class.java)

      Ok(account)
    } catch (e: ApiException) {
      val errorMessage =
        "Sign in failed: " + GoogleSignInStatusCodes.getStatusCodeString(e.statusCode)
      Log.w(TAG, errorMessage)

      Err(errorMessage)
    }
  }
}