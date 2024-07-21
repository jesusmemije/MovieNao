package com.memije.movienao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.memije.movienao.ui.HomeScreen
import com.memije.movienao.ui.LandingScreen
import com.memije.movienao.ui.LoginScreen
import com.memije.movienao.ui.SettingsScreen
import com.memije.movienao.ui.SignupScreen
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.utils.BottomNavigationBar
import com.memije.movienao.ui.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieNaoTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    if (showBottomBar(navController)) BottomNavigationBar()
                }, content = { padding ->
                    NavHost(
                        navController = navController, startDestination = Routes.Settings.route
                    ) {
                        composable(Routes.Landing.route) { LandingScreen(navController) }
                        composable(Routes.Login.route) { LoginScreen(navController) }
                        composable(Routes.SignUp.route) { SignupScreen(navController) }
                        composable(Routes.Home.route) { HomeScreen(Modifier.padding(padding)) }
                        composable(Routes.Settings.route) { SettingsScreen(Modifier.padding(padding)) }
                    }
                })
            }
        }
    }
}

@Composable
fun showBottomBar(navController: NavHostController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return when (navBackStackEntry?.destination?.route) {
        Routes.Landing.route -> false
        Routes.Login.route -> false
        Routes.SignUp.route -> false
        else -> true
    }
}