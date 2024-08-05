package com.memije.movienao.main.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.movienao.main.home.data.network.response.Result
import com.memije.movienao.main.home.domain.GetPopularMoviesUseCase
import com.memije.movienao.main.home.domain.GetTopMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopMoviesUseCase: GetTopMoviesUseCase
) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<Result>>()
    val popularMovies: LiveData<List<Result>> = _popularMovies

    private val _topMovies = MutableLiveData<List<Result>>()
    val topMovies: LiveData<List<Result>> = _topMovies

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    fun getPopularMovies() {
        viewModelScope.launch {
            runCatching {
                getPopularMoviesUseCase()
            }.onSuccess { response ->
                _popularMovies.postValue(response.results)
            }.onFailure {
                _error.postValue(true)
            }
        }
    }

    fun getTopMovies() {
        viewModelScope.launch {
            runCatching {
                getTopMoviesUseCase()
            }.onSuccess { response ->
                _topMovies.postValue(response.results)
            }.onFailure {
                _error.postValue(true)
            }
        }
    }

    fun getMovieDetail() {
        TODO("Not yet implemented")
    }
}