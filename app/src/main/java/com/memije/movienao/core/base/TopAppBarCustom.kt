package com.memije.movienao.core.base

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.memije.movienao.core.theme.BlackApp
import com.memije.movienao.core.theme.WhiteApp

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
        ),
        modifier = Modifier.shadow(
            elevation = 10.dp, //or whatever value
            spotColor = Color.Black
        )
    )
}

@Composable
fun getScreenName(navController: NavHostController): String {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return when (navBackStackEntry?.destination?.route) {
        Routes.Settings.route -> "Settings"
        Routes.Favorites.route -> "Favorites"
        Routes.Search.route -> "Search"
        Routes.MovieDetail.route -> "Details"
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