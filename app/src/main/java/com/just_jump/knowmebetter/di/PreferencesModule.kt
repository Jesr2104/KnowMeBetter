package com.just_jump.knowmebetter.di

import android.content.Context
import com.just_jump.knowmebetter.data.datasource.local.datastore.DataStoreLocalDataSource
import com.just_jump.knowmebetter.utilities.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun providePreferences(@ApplicationContext app: Context): DataStoreLocalDataSource = DataStoreLocalDataSource(app)
}