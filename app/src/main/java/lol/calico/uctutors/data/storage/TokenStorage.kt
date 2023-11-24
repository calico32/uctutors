package lol.calico.uctutors.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenStorage(private val context: Context) {
  companion object {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("session")
    val TOKEN_KEY = stringPreferencesKey("session")
  }

  val getToken: Flow<String> = context.dataStore.data
    .map { preferences ->
      preferences[TOKEN_KEY] ?: ""
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