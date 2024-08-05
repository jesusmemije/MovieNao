package com.memije.movienao.main.home.data.network.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val results: List<Result>,
)

data class Result(
    val id: Long,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("poster_path") val posterPath: String,
    val title: String,
)