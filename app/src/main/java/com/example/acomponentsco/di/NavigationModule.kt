package com.example.acomponentsco.di

import com.example.acomponentsco.ACompApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Provides
    fun provideRouter()=ACompApplication.INSTANCE.router



}