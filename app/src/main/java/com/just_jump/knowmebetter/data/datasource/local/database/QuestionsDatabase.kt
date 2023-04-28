package com.just_jump.knowmebetter.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.just_jump.knowmebetter.data.datasource.local.database.dao.QuestionDao
import com.just_jump.knowmebetter.data.datasource.local.database.entities.QuestionsEntity

@Database(entities = [QuestionsEntity::class], version = 1)
abstract class QuestionsDatabase:RoomDatabase(){
    abstract fun getQuestionDao(): QuestionDao
}