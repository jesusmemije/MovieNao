package com.memije.movienao.main.moviedetail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memije.movienao.R
import com.memije.movienao.core.theme.BlackApp
import com.memije.movienao.core.theme.GrayLightApp
import com.memije.movienao.core.theme.MovieNaoTheme

@Composable
fun MovieDetailScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackApp)
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.movie_cover),
            contentDescription = "Movie Cover",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(16.dp))
        ContentDescription()
        Spacer(modifier = Modifier.size(16.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "Episodes",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Season("Season 1")
            Season("Season 2")
            Season("Season 3")
        }
    }
}

@Composable
fun Season(season: String) {
    Spacer(modifier = Modifier.size(8.dp))
    Text(text = season, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.size(8.dp))
    Episodes()
    Episodes()
    Episodes()
}

@Composable
fun Episodes() {
    Row(modifier = Modifier.padding(vertical = 16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.episode),
            contentDescription = "Image Episode",
            modifier = Modifier.width(120.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Row {
                Text(
                    text = "Episode 1",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "47m", color = GrayLightApp, fontSize = 13.sp)
            }
            Text(
                text = "Tormented by her high school classmates and with nowhere...",
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun ContentDescription() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "The Glory", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = "2022", color = GrayLightApp, fontSize = 12.sp)
            Text(text = "|", color = GrayLightApp, modifier = Modifier.padding(horizontal = 4.dp))
            Text(text = "18+", color = GrayLightApp, fontSize = 12.sp)
            Text(text = "|", color = GrayLightApp, modifier = Modifier.padding(horizontal = 4.dp))
            Text(text = "1 Season", color = GrayLightApp, fontSize = 12.sp)
            Text(text = "|", color = GrayLightApp, modifier = Modifier.padding(horizontal = 4.dp))
            Text(text = "K-Drama", color = GrayLightApp, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify,
            text = "A young woman, bullied to the point of deciding to drop out of school, plans the best way to get revenge. After becoming a primary school teacher, she takes in the son of the man who tormented her the most to enact her vengeance."
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Text(color = Color.White, fontSize = 14.sp, text = "Starring : ")
            Text(
                color = Color.White,
                fontSize = 14.sp,
                text = "Song Hye-kyo, Lee Do-hyun, Lim Ji-yeon"
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Text(color = Color.White, fontSize = 14.sp, text = "Creators : ")
            Text(color = Color.White, fontSize = 14.sp, text = "Kim Eun-sook, An Gil-ho")
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Text(color = Color.White, fontSize = 14.sp, text = "Genre : ")
            Text(color = Color.White, fontSize = 14.sp, text = "Revenge, Psychological Thriller")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MovieNaoTheme {
        MovieDetailScreen()
    }
}