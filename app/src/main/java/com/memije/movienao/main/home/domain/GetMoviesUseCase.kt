package com.memije.movienao.main.home.domain

import com.memije.movienao.main.home.data.MovieRepository
import com.memije.movienao.main.home.data.network.response.MovieResponse
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() : MovieResponse {
        return movieRepository.getMovies()
    }
}