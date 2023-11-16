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
  // to make sure there's only one instance
  companion object {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token")
    val TOKEN_KEY = stringPreferencesKey("token")
  }

  //get the saved email
  val getToken: Flow<String> = context.dataStore.data
    .map { preferences ->
      preferences[TOKEN_KEY] ?: ""
    }

  //save email into datastore
  suspend fun saveToken(token: String) {
    context.dataStore.edit { preferences ->
      preferences[TOKEN_KEY] = token
    }
  }
}