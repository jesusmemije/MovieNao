package com.memije.movienao.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.memije.movienao.core.base.AppConstants
import com.memije.movienao.core.base.Routes
import com.memije.movienao.core.theme.WhiteApp
import com.memije.movienao.main.home.data.network.response.Result

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
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(AppConstants.URL_IMAGES + movie.posterPath).crossfade(true)
                .build(),
            modifier = Modifier
                .width(120.dp)
                .height(180.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    navController?.navigate(Routes.MovieDetail.createRoute(movie.id))
                },
            contentDescription = "Movie",
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.width(120.dp),
            text = movie.title,
            color = Color.White,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
        )
    }
}