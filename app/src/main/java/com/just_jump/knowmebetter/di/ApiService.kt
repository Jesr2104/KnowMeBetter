package com.just_jump.knowmebetter.di

import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("exec?action=getQuestions")
    suspend fun getQuestions(): Response<ArrayList<QuestionDataModel>>
}