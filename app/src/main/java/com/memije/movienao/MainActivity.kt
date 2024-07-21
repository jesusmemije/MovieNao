package com.memije.movienao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.memije.movienao.ui.FavoritesScreen
import com.memije.movienao.ui.HomeScreen
import com.memije.movienao.ui.LandingScreen
import com.memije.movienao.ui.LoginScreen
import com.memije.movienao.ui.SearchScreen
import com.memije.movienao.ui.SettingsScreen
import com.memije.movienao.ui.SignupScreen
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.utils.BottomNavigationBar
import com.memije.movienao.ui.utils.Routes
import com.memije.movienao.ui.utils.TopAppBarCustom
import com.memije.movienao.ui.utils.showBottomBar
import com.memije.movienao.ui.utils.showTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieNaoTheme {
                val navController = rememberNavController()
                Scaffold(topBar = {
                    if (showTopBar(navController)) TopAppBarCustom(navController)
                }, bottomBar = {
                    if (showBottomBar(navController)) BottomNavigationBar(navController)
                }, content = { padding ->
                    NavHost(
                        navController = navController, startDestination = Routes.Landing.route
                    ) {
                        composable(Routes.Landing.route) { LandingScreen(navController) }
                        composable(Routes.Login.route) { LoginScreen(navController) }
                        composable(Routes.SignUp.route) { SignupScreen(navController) }
                        composable(Routes.Home.route) { HomeScreen(Modifier.padding(padding)) }
                        composable(Routes.Settings.route) { SettingsScreen(Modifier.padding(padding)) }
                        composable(Routes.Favorites.route) { FavoritesScreen(Modifier.padding(padding)) }
                        composable(Routes.Search.route) { SearchScreen(Modifier.padding(padding)) }
                    }
                })
            }
        }
    }
}