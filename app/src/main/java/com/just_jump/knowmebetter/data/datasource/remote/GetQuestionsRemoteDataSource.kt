package com.just_jump.knowmebetter.data.datasource.remote

import com.just_jump.knowmebetter.di.ApiService
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetQuestionsRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getQuestionsFromApi(
        language: String,
        onResult: (ArrayList<QuestionDataModel>) -> Unit,
    ){
        return withContext(Dispatchers.IO){
            val response = apiService.getQuestions(language)
            val result = response.body() ?: arrayListOf()

            onResult(result)
        }
    }
}