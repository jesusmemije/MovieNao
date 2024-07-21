package com.memije.movienao.ui.utils

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.WhiteApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarCustom(navController: NavHostController) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = getScreenName(navController), fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BlackApp,
            titleContentColor = WhiteApp,
        )
    )
}

@Composable
fun getScreenName(navController: NavHostController): String {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return when (navBackStackEntry?.destination?.route) {
        Routes.Settings.route -> "Settings"
        else -> ""
    }
}

@Composable
fun showTopBar(navController: NavHostController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return when (navBackStackEntry?.destination?.route) {
        Routes.Landing.route -> false
        Routes.Login.route -> false
        Routes.SignUp.route -> false
        Routes.Home.route -> false
        else -> true
    }
}