package lol.calico.uctutors.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import lol.calico.uctutors.data.common.GrpcConnection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class TokenStorage @Inject constructor(
  @ActivityContext private val context: Context,
  private val grpc: GrpcConnection,
) {
  companion object {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("session")
    val TOKEN_KEY = stringPreferencesKey("session")
  }

  fun propagateToken(scope: CoroutineScope) {
    scope.launch {
      token.collect { token ->
        if (token != null) {
          grpc.authenticate(token)
        } else {
          grpc.deauthenticate()
        }
      }
    }
  }

  val token: Flow<String?> = context.dataStore.data.map { preferences ->
    preferences[TOKEN_KEY]
  }

  suspend fun clearToken() {
    context.dataStore.edit { preferences ->
      preferences.remove(TOKEN_KEY)
    }
  }

  suspend fun saveToken(token: String) {
    context.dataStore.edit { preferences ->
      preferences[TOKEN_KEY] = token
    }
  }
}