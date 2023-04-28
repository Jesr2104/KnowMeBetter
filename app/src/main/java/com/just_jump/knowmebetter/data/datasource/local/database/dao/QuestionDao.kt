package com.just_jump.knowmebetter.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.just_jump.knowmebetter.data.datasource.local.database.entities.QuestionsEntity

@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions_table")
    suspend fun getAllQuestions(): List<QuestionsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<QuestionsEntity>)

    @Query("DELETE FROM questions_table")
    suspend fun clearAll()
}