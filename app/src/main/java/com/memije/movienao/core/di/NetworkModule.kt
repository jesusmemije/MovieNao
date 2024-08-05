package com.memije.movienao.core.di

import com.memije.movienao.core.base.AppConstants
import com.memije.movienao.main.home.data.network.MovieClient
import com.memije.movienao.main.moviedetail.data.network.MovieDetailClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("accept", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NTExODQzZTliOTFkZDAzM2Y4NDRkMGQ3MWM5NzQxMiIsIm5iZiI6MTcyMjg4ODU2Ni4zNjUxMywic3ViIjoiNWYyYzRiYmFjNTFhY2QwMDM3OWJjMTkwIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.MtlrAGhad3S139Gw9dgTCg-o_56QBgRauePRBMsg1X4")
                .build()
            chain.proceed(request)
        }

        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
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