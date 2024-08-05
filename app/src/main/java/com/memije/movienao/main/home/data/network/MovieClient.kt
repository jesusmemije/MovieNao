package com.memije.movienao.main.home.data.network

import com.memije.movienao.main.home.data.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieClient {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NTExODQzZTliOTFkZDAzM2Y4NDRkMGQ3MWM5NzQxMiIsIm5iZiI6MTcyMjc5MjAzNC4xNTcwMDEsInN1YiI6IjVmMmM0YmJhYzUxYWNkMDAzNzliYzE5MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0B_WcorbqRLDjrbPZH_6eWDMAv_LZrJxyKNVMNohr1Q")
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NTExODQzZTliOTFkZDAzM2Y4NDRkMGQ3MWM5NzQxMiIsIm5iZiI6MTcyMjc5MjAzNC4xNTcwMDEsInN1YiI6IjVmMmM0YmJhYzUxYWNkMDAzNzliYzE5MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0B_WcorbqRLDjrbPZH_6eWDMAv_LZrJxyKNVMNohr1Q")
    @GET("movie/top_rated")
    suspend fun getTopMovies(): Response<MovieResponse>
}