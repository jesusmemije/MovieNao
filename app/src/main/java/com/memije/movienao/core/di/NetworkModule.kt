package com.memije.movienao.core.di

import com.memije.movienao.main.home.data.network.MovieClient
import com.memije.movienao.main.moviedetail.data.network.MovieDetailClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieClient(retrofit: Retrofit): MovieClient {
        return retrofit.create(MovieClient::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieDetailClient(retrofit: Retrofit): MovieDetailClient {
        return retrofit.create(MovieDetailClient::class.java)
    }

}