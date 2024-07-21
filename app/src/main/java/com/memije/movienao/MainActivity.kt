package com.memije.movienao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.memije.movienao.ui.HomeScreen
import com.memije.movienao.ui.LandingScreen
import com.memije.movienao.ui.LoginScreen
import com.memije.movienao.ui.SignupScreen
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieNaoTheme {
                val navigationController = rememberNavController()
                NavHost(
                    navController = navigationController, startDestination = Routes.Landing.route
                ) {
                    composable(Routes.Landing.route) { LandingScreen(navigationController) }
                    composable(Routes.Login.route) { LoginScreen(navigationController) }
                    composable(Routes.SignUp.route) { SignupScreen(navigationController) }
                    composable(Routes.Home.route) { HomeScreen(Modifier, navigationController) }
                }
            }
        }
    }
}