package com.nextgen.tes.di

import com.nextgen.tes.data.remote.api.ApiConfig
import com.nextgen.tes.data.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ApiConfig.getApiService()
}