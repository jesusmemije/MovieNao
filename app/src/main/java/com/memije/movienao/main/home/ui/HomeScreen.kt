package com.memije.movienao.main.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.memije.movienao.R
import com.memije.movienao.core.base.Routes
import com.memije.movienao.core.theme.BlackApp
import com.memije.movienao.core.theme.WhiteApp
import com.memije.movienao.main.home.data.network.response.Result

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel,
) {
    val scrollState = rememberScrollState()
    val popularMovies = homeViewModel.popularMovies.observeAsState()
    val topMovies = homeViewModel.topMovies.observeAsState()

    homeViewModel.getMovies()
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
        CarouselMovies("Popular Movie", navController, popularMovies.value)
        CarouselMovies("Top Rated", navController, topMovies.value)
    }
}

@Composable
fun CarouselMovies(
    title: String,
    navController: NavHostController?,
    movies: List<Result>?,
) {
    movies?.let { items ->
        Column {
            Text(
                text = title,
                color = WhiteApp,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                items(items) { movie ->
                    ItemCardMovie(navController, movie)
                }
            }
        }
    }
}

@Composable
fun ItemCardMovie(navController: NavHostController?, movie: Result) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .fillMaxHeight()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/original/" + movie.posterPath).crossfade(true)
                .build(),
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    navController?.navigate(Routes.MovieDetail.route)
                },
            contentDescription = "Movie",
            contentScale = ContentScale.Crop
        )
        Text(
            text = movie.title ?: movie.name.orEmpty(),
            color = Color.White,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
        )
    }
}