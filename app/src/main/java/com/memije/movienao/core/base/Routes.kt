package com.memije.movienao.core.base

sealed class Routes(val route: String) {
    data object Landing: Routes("landing")
    data object Login: Routes("login")
    data object SignUp: Routes("signup")
    data object Home: Routes("home")
    data object Settings: Routes("settings")
    data object Favorites: Routes("favorites")
    data object Search: Routes("search")
    data object MovieDetail: Routes("movie_detail/{id}") {
        fun createRoute(id: Long) = "movie_detail/$id"
    }
}