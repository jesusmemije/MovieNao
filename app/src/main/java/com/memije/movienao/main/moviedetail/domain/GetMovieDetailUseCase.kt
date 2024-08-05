package com.memije.movienao.main.moviedetail.domain

import com.memije.movienao.main.moviedetail.data.MovieDetailRepository
import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val movieDetailRepository: MovieDetailRepository) {
    suspend operator fun invoke(id: Long) : MovieDetailResponse {
        return movieDetailRepository.getMovieDetail(id)
    }
}