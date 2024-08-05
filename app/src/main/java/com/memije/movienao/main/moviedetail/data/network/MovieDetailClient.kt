package com.memije.movienao.main.moviedetail.data.network

import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MovieDetailClient {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NTExODQzZTliOTFkZDAzM2Y4NDRkMGQ3MWM5NzQxMiIsIm5iZiI6MTcyMjc5MjAzNC4xNTcwMDEsInN1YiI6IjVmMmM0YmJhYzUxYWNkMDAzNzliYzE5MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0B_WcorbqRLDjrbPZH_6eWDMAv_LZrJxyKNVMNohr1Q")
    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Long): Response<MovieDetailResponse>
}