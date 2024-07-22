package com.memije.movienao.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.DarkApp
import com.memije.movienao.ui.theme.GreenApp
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.theme.WhiteApp

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    var search by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BlackApp)
    ) {
        CustomSearchView(search = search, onValueChange = {
            search = it
        })
    }
}

@Composable
fun CustomSearchView(
    search: String, onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(28.dp))
    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            leadingIcon = { Icon(imageVector = Icons.Default.Menu, contentDescription = "") },
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            placeholder = { Text(text = "Search") },
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = GreenApp,
                unfocusedPlaceholderColor = GreenApp,
                unfocusedContainerColor = DarkApp,
                unfocusedLeadingIconColor = GreenApp,
                unfocusedTrailingIconColor = GreenApp,
                unfocusedIndicatorColor = Color.Transparent,

                focusedTextColor = WhiteApp,
                focusedPlaceholderColor = WhiteApp,
                focusedContainerColor = DarkApp,
                focusedLeadingIconColor = WhiteApp,
                focusedTrailingIconColor = WhiteApp,
                focusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MovieNaoTheme {
        SearchScreen()
    }
}