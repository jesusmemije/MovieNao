package com.memije.movienao.main.home.data.network.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val results: List<Result>
)

data class Result(
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("title") val title: String? = "",
    @SerializedName("name") val name: String? = "",
)
