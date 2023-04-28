package com.just_jump.knowmebetter.data.datasource.local.database

import com.just_jump.knowmebetter.data.datasource.local.database.dao.QuestionDao
import com.just_jump.knowmebetter.data.datasource.local.database.entities.QuestionsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionsLocalDataSource @Inject constructor(
    private val questionDao: QuestionDao
){
    suspend fun getAllQuestions(onResult: (List<QuestionsEntity>) -> Unit){
        return withContext(Dispatchers.IO){
            val response = questionDao.getAllQuestions()
            onResult(response)
        }
    }

    suspend fun insertQuestions(questions: List<QuestionsEntity>){
        return withContext(Dispatchers.IO){
            questionDao.insertAll(questions)
        }
    }

    suspend fun clearQuestions(){
        return withContext(Dispatchers.IO){
            questionDao.clearAll()
        }
    }
}