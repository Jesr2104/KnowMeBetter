package com.just_jump.knowmebetter.di

import android.content.Context
import androidx.room.Room
import com.just_jump.knowmebetter.data.datasource.local.database.QuestionsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUESTIONS_DATABASE_NAME = "questions_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, QuestionsDatabase::class.java, QUESTIONS_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(db: QuestionsDatabase) = db.getQuestionDao()
}
