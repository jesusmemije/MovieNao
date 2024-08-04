package com.memije.movienao.main.favorites.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memije.movienao.R
import com.memije.movienao.framework.theme.BlackApp
import com.memije.movienao.framework.theme.GrayLightApp
import com.memije.movienao.framework.theme.GreenDarkApp
import com.memije.movienao.framework.theme.GreenLightApp
import com.memije.movienao.framework.theme.MovieNaoTheme
import com.memije.movienao.framework.theme.WhiteApp

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(BlackApp)
    ) {
        item { ItemMovie() }
        item { ItemMovie() }
        item { ItemMovie() }
        item { ItemMovie() }
    }
}

@Composable
fun ItemMovie() {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.movie_favorite),
            contentDescription = "Image Movie",
            modifier = Modifier.height(80.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(
                text = "Warriors", color = WhiteApp, fontWeight = FontWeight.Bold, fontSize = 16.sp
            )
            Text(
                text = "2019",
                color = GrayLightApp,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Icon Options",
                tint = WhiteApp,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Downloaded",
                modifier = Modifier
                    .background(GreenLightApp, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp),
                color = GreenDarkApp,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    MovieNaoTheme {
        FavoritesScreen()
    }
}