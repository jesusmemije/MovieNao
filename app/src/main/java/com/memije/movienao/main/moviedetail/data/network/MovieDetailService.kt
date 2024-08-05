package com.memije.movienao.main.moviedetail.data.network

import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailService @Inject constructor(private val movieDetailClient: MovieDetailClient) {
    suspend fun getMovieDetail(id: Long): MovieDetailResponse {
        return withContext(Dispatchers.IO) {
            val response = movieDetailClient.getMovieDetail(id)
            response.body()!!
        }
    }
}