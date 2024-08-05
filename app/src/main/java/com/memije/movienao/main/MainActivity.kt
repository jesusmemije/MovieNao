package com.memije.movienao.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.memije.movienao.main.favorites.ui.FavoritesScreen
import com.memije.movienao.main.home.ui.HomeScreen
import com.memije.movienao.main.landing.ui.LandingScreen
import com.memije.movienao.main.login.ui.LoginScreen
import com.memije.movienao.main.moviedetail.ui.MovieDetailScreen
import com.memije.movienao.main.search.ui.SearchScreen
import com.memije.movienao.main.settings.ui.SettingsScreen
import com.memije.movienao.main.signup.ui.SignupScreen
import com.memije.movienao.core.theme.MovieNaoTheme
import com.memije.movienao.core.base.BottomNavigationBar
import com.memije.movienao.core.base.Routes
import com.memije.movienao.core.base.TopAppBarCustom
import com.memije.movienao.core.base.showBottomBar
import com.memije.movienao.core.base.showTopBar
import com.memije.movienao.main.home.ui.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

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
                        composable(Routes.Home.route) { HomeScreen(Modifier.padding(padding), navController, homeViewModel) }
                        composable(Routes.Settings.route) { SettingsScreen(Modifier.padding(padding)) }
                        composable(Routes.Favorites.route) { FavoritesScreen(Modifier.padding(padding)) }
                        composable(Routes.Search.route) { SearchScreen(Modifier.padding(padding)) }
                        composable(
                            Routes.MovieDetail.route,
                            listOf(navArgument("id") { type = NavType.LongType })
                        ) { backStackEntry ->
                            MovieDetailScreen(Modifier.padding(padding), backStackEntry.arguments?.getLong("id") ?: 0, homeViewModel)
                        }
                    }
                })
            }
        }
    }
}