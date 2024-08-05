package com.memije.movienao.main.moviedetail.data.network

import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailClient {
    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Long): Response<MovieDetailResponse>
}