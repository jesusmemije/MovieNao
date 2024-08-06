package com.memije.movienao.main.moviedetail.data

import com.memije.movienao.main.home.data.network.response.MovieResponse
import com.memije.movienao.main.moviedetail.data.network.MovieDetailService
import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(private val movieDetailService: MovieDetailService) {
    suspend fun getMovieDetail(id: Long): MovieDetailResponse? {
        return movieDetailService.getMovieDetail(id)
    }

    suspend fun getSimilarMovies(id: Long): MovieResponse? {
        return movieDetailService.getSimilarMovies(id)
    }

    suspend fun getRecommendedMovies(id: Long): MovieResponse? {
        return movieDetailService.getRecommendedMovies(id)
    }
}