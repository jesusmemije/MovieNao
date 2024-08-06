package com.memije.movienao.main.moviedetail.domain

import com.memije.movienao.main.home.data.network.response.MovieResponse
import com.memije.movienao.main.moviedetail.data.MovieDetailRepository
import javax.inject.Inject

class GetRecommendedMoviesUseCase @Inject constructor(private val movieDetailRepository: MovieDetailRepository) {
    suspend operator fun invoke(id: Long): MovieResponse? {
        return movieDetailRepository.getRecommendedMovies(id)
    }
}