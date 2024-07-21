package com.memije.movienao.ui.utils

sealed class Routes(val route: String) {
    data object Landing: Routes("landing")
    data object Login: Routes("login")
    data object SignUp: Routes("signup")
    data object Home: Routes("home")
    data object Settings: Routes("settings")
    data object Favorites: Routes("favorites")
}