package com.memije.movienao.main.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.memije.movienao.R
import com.memije.movienao.core.components.CarouselMovies
import com.memije.movienao.core.theme.BlackApp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    val popularMovies = homeViewModel.popularMovies.observeAsState()
    val topMovies = homeViewModel.topMovies.observeAsState()

    homeViewModel.getPopularMovies()
    homeViewModel.getTopMovies()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackApp)
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.poster),
            contentDescription = "poster",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        CarouselMovies(context.resources.getString(R.string.popular_movie), navController, popularMovies.value)
        CarouselMovies(context.resources.getString(R.string.top_rated), navController, topMovies.value)
    }
}