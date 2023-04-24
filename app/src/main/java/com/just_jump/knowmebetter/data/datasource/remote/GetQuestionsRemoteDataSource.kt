package com.just_jump.knowmebetter.data.datasource.remote

import com.just_jump.knowmebetter.di.ApiService
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetQuestionsRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getQuestionsFromApi(
        onResult: (ArrayList<QuestionDataModel>) -> Unit,
    ){
        return withContext(Dispatchers.IO){
            val response = apiService.getQuestions()
            val result = response.body() ?: arrayListOf()

            onResult(result)
        }
    }
}