package com.memije.movienao.main.moviedetail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.movienao.main.home.data.network.response.Result
import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import com.memije.movienao.main.moviedetail.domain.GetMovieDetailUseCase
import com.memije.movienao.main.moviedetail.domain.GetRecommendedMoviesUseCase
import com.memije.movienao.main.moviedetail.domain.GetSimilarMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase,
    private val getRecommendedMoviesUseCase: GetRecommendedMoviesUseCase
) : ViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetailResponse>()
    val movieDetail: LiveData<MovieDetailResponse> = _movieDetail

    private val _similarMovies = MutableLiveData<List<Result>>()
    val similarMovies: LiveData<List<Result>> = _similarMovies

    private val _recommendedMovies = MutableLiveData<List<Result>>()
    val recommendedMovies: LiveData<List<Result>> = _recommendedMovies

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    fun getMovieDetail(id: Long) {
        viewModelScope.launch {
            runCatching {
                getMovieDetailUseCase(id)
            }.onSuccess { response ->
                response?.let { movie -> _movieDetail.postValue(movie) }.also { _error.postValue(true) }
            }.onFailure {
                _error.postValue(true)
            }
        }
    }

    fun getSimilarMovies(id: Long) {
        viewModelScope.launch {
            runCatching {
                getSimilarMoviesUseCase(id)
            }.onSuccess { response ->
                response?.results?.let { movies -> _similarMovies.postValue(movies) }.also { _error.postValue(true) }
            }.onFailure {
                _error.postValue(true)
            }
        }
    }

    fun getRecommendedMovies(id: Long) {
        viewModelScope.launch {
            runCatching {
                getRecommendedMoviesUseCase(id)
            }.onSuccess { response ->
                response?.results?.let { movies -> _recommendedMovies.postValue(movies) }.also { _error.postValue(true) }
            }.onFailure {
                _error.postValue(true)
            }
        }
    }
}