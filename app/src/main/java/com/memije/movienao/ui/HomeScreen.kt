package com.memije.movienao.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.movienao.R
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.theme.WhiteApp

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigationController: NavHostController? = null) {
    val scrollState = rememberScrollState()
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
        PopularMovie("Popular Movie")
        PopularMovie("New and Noteworthy")
    }
}

@Composable
fun PopularMovie(title: String) {
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
            item { ItemCardMovie() }
            item { ItemCardMovie() }
            item { ItemCardMovie() }
            item { ItemCardMovie() }
        }
    }
}

@Composable
fun ItemCardMovie() {
    Image(
        painter = painterResource(id = R.drawable.movie_1),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentDescription = "Movie",
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MovieNaoTheme {
        HomeScreen()
    }
}