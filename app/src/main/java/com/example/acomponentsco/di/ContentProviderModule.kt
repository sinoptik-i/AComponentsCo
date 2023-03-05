package com.example.acomponentsco.di

import android.content.Context
import com.example.acomponentsco.contentProvider.ContactManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ContentProviderModule {

    @Provides
    fun provideContactManager(
        @ApplicationContext context: Context
    ) = ContactManager(context)


}