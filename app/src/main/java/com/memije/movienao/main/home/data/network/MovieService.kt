package com.memije.movienao.main.home.data.network

import com.memije.movienao.main.home.data.network.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val movieClient: MovieClient) {
    suspend fun getPopularMovies(): MovieResponse {
        return withContext(Dispatchers.IO) {
            val response = movieClient.getPopularMovies()
            response.body()!!
        }
    }

    suspend fun getTopMovies(): MovieResponse {
        return withContext(Dispatchers.IO) {
            val response = movieClient.getTopMovies()
            response.body()!!
        }
    }
}