package com.harikrish.fitzy.di

import com.harikrish.fitzy.data.api.FitzyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://fakestoreapi.com"
    private const val SECOND_BASE_URL = "https://api.escuelajs.co/api"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFitzyApi(retrofit: Retrofit): FitzyApi {
        return retrofit.create(FitzyApi::class.java)
    }

}
