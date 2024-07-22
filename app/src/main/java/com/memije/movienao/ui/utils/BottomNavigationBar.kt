package com.memije.movienao.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.GrayApp
import com.memije.movienao.ui.theme.GreenApp

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    var index by remember { mutableIntStateOf(0) }

    NavigationBar(containerColor = BlackApp, contentColor = GrayApp) {
        NavigationBarItem(selected = index == 0, onClick = {
            index = 0
            navController.navigate(Routes.Home.route)
        }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") }, colors = NavigationBarItemColors()
        )
        NavigationBarItem(selected = index == 1, onClick = {
            index = 1
            navController.navigate(Routes.Search.route)
        }, icon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        }, label = { Text(text = "Search") }, colors = NavigationBarItemColors()
        )

        NavigationBarItem(selected = index == 2, onClick = {
            index = 2
            navController.navigate(Routes.Favorites.route)
        }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorites")
        }, label = { Text(text = "Favorites") }, colors = NavigationBarItemColors()
        )

        NavigationBarItem(selected = index == 3, onClick = {
            index = 3
            navController.navigate(Routes.Settings.route)
        }, icon = {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
        }, label = { Text(text = "Settings") }, colors = NavigationBarItemColors()
        )
    }
}

fun NavigationBarItemColors(): NavigationBarItemColors {
    return NavigationBarItemColors(
        selectedIconColor = GreenApp,
        selectedTextColor = GreenApp,
        selectedIndicatorColor = Color.Transparent,
        unselectedIconColor = GrayApp,
        unselectedTextColor = GrayApp,
        disabledIconColor = GrayApp,
        disabledTextColor = GrayApp
    )
}


@Composable
fun showBottomBar(navController: NavHostController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return when (navBackStackEntry?.destination?.route) {
        Routes.Landing.route -> false
        Routes.Login.route -> false
        Routes.SignUp.route -> false
        Routes.MovieDetail.route -> false
        else -> true
    }
}