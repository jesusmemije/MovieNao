package com.memije.movienao.main.home.data.network

import com.memije.movienao.main.home.data.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieClient {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopMovies(): Response<MovieResponse>
}