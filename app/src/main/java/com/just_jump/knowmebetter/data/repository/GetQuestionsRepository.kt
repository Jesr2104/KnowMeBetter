package com.just_jump.knowmebetter.data.repository

import com.just_jump.knowmebetter.data.datasource.local.database.QuestionsLocalDataSource
import com.just_jump.knowmebetter.data.datasource.remote.GetQuestionsRemoteDataSource
import com.just_jump.knowmebetter.domain.datamodels.QuestionDataModel
import com.just_jump.knowmebetter.utilities.toDomain
import javax.inject.Inject

class GetQuestionsRepository @Inject constructor(
    private val getQuestionsRemoteDataSource: GetQuestionsRemoteDataSource,
    private val questionsLocalDataSource: QuestionsLocalDataSource
) {
    suspend fun getQuestionsFromApi(language: String, onResult: (ArrayList<QuestionDataModel>) -> Unit) {
        getQuestionsRemoteDataSource.getQuestionsFromApi(language) {
            onResult(it)
        }
    }

    suspend fun getQuestionsFromRoom(language: String, onResult: (ArrayList<QuestionDataModel>) -> Unit){
        questionsLocalDataSource.getAllQuestions { QuestionsList ->
            val result = QuestionsList.map{ it.toDomain() } as ArrayList<QuestionDataModel>
            onResult(result)
        }
    }

    suspend fun insertQuestions(questions: ArrayList<QuestionDataModel>){
        val result = questions.map { it.toDomain() }
        questionsLocalDataSource.insertQuestions(result)
    }

    suspend fun clearAllQuestions(){
        questionsLocalDataSource.clearQuestions()
    }
}