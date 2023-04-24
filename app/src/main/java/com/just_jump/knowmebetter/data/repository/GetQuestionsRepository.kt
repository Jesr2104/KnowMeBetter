package com.just_jump.knowmebetter.data.repository

import com.just_jump.knowmebetter.data.datasource.remote.GetQuestionsRemoteDataSource
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import javax.inject.Inject

class GetQuestionsRepository @Inject constructor(
    private val getQuestionsRemoteDataSource: GetQuestionsRemoteDataSource
) {
    suspend fun getQuestions(onResult: (ArrayList<QuestionDataModel>) -> Unit){
        getQuestionsRemoteDataSource.getQuestionsFromApi {
            onResult(it)
        }
    }
}