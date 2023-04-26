package com.just_jump.knowmebetter.data.repository

import com.just_jump.knowmebetter.data.datasource.local.datastore.DataStoreLocalDataSource
import javax.inject.Inject

class ManagerLanguageRepository @Inject constructor(
    private val dataSourceLocalDataSource: DataStoreLocalDataSource,
) {
    suspend fun setLanguageValue(language: String, onResult: (Boolean) -> Unit) {
        dataSourceLocalDataSource.setLanguageValue(language) {
            onResult(it)
        }
    }

    suspend fun getLanguageValue(onResult: (String) -> Unit) {
        dataSourceLocalDataSource.getLanguageValue {
            onResult(it)
        }
    }
}