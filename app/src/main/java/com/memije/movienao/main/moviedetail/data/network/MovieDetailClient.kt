package com.memije.movienao.main.moviedetail.data.network

import com.memije.movienao.main.home.data.network.response.MovieResponse
import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailClient {
    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Long,
        @Query("language") language: String = "es-ES",
    ): Response<MovieDetailResponse>

    @GET("movie/{id}/similar")
    suspend fun getSimilarMovies(@Path("id") id: Long): Response<MovieResponse>

    @GET("movie/{id}/recommendations")
    suspend fun getRecommendedMovies(@Path("id") id: Long): Response<MovieResponse>
}