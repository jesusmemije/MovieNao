package com.memije.movienao.main.home.data

import com.memije.movienao.main.home.data.network.MovieService
import com.memije.movienao.main.home.data.network.response.MovieResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieService: MovieService) {
    suspend fun getMovies() : MovieResponse {
        return movieService.getMovies()
    }

    suspend fun getTopMovies() : MovieResponse {
        return movieService.getTopMovies()
    }
}