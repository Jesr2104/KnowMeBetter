package com.just_jump.knowmebetter.data.datasource.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private const val PREFERENCES_NAME = "language_setup"
private const val KEY = "languageDataStore"
private val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreLocalDataSource @Inject constructor(
    private val context: Context,
) {
    suspend fun setLanguageValue(language: String, onResult: (Boolean) -> Unit) {
        val preferencesKey = stringPreferencesKey(KEY)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = language
            onResult(true)
        }
    }

    suspend fun getLanguageValue(onResult: (String) -> Unit) {
        var result = ""
        result = try {
            val preferencesKey = stringPreferencesKey(KEY)
            val preferences =  context.dataStore.data.first()
            preferences[preferencesKey].toString()
        } catch (e: Exception) {
            e.printStackTrace()
            "EN"
        }
        onResult(result)
    }
}