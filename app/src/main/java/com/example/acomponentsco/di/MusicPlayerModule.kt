package com.example.acomponentsco.di

import android.content.Context
import com.example.acomponentsco.contentProvider.FileManager
import com.example.acomponentsco.service.MusicPlayer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MusicPlayerModule {

    @Provides
    fun providesMusicPlayer(
        @ApplicationContext context: Context
    ) = MusicPlayer(context, FileManager())// почему FileManager сам не прокидывается из другого модуля?
}