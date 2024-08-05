package com.memije.movienao.main.moviedetail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.movienao.main.moviedetail.data.network.response.MovieDetailResponse
import com.memije.movienao.main.moviedetail.domain.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetailResponse>()
    val movieDetail: LiveData<MovieDetailResponse> = _movieDetail

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    fun getMovieDetail(id: Long) {
        viewModelScope.launch {
            runCatching {
                getMovieDetailUseCase(id)
            }.onSuccess { response ->
                _movieDetail.postValue(response)
            }.onFailure {
                _error.postValue(true)
            }
        }
    }
}