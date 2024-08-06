package com.memije.movienao.main.moviedetail.data.network

import com.memije.movienao.main.home.data.network.response.MovieResponse
import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailService @Inject constructor(private val movieDetailClient: MovieDetailClient) {
    suspend fun getMovieDetail(id: Long): MovieDetailResponse? {
        return withContext(Dispatchers.IO) {
            val response = movieDetailClient.getMovieDetail(id)
            response.body()
        }
    }

    suspend fun getSimilarMovies(id: Long): MovieResponse? {
        return withContext(Dispatchers.IO) {
            val response = movieDetailClient.getSimilarMovies(id)
            response.body()
        }
    }

    suspend fun getRecommendedMovies(id: Long): MovieResponse? {
        return withContext(Dispatchers.IO) {
            val response = movieDetailClient.getRecommendedMovies(id)
            response.body()
        }
    }
}