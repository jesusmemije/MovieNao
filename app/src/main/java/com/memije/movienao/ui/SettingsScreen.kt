package com.memije.movienao.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memije.movienao.R
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.theme.WhiteApp

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackApp)
    ) {
        AvatarAccount()
        ItemMenu(Icons.Default.Person, "Account")
        ItemMenu(Icons.Default.Lock, "Privacity")
        ItemMenu(Icons.Default.PlayCircle, "Appearance")
        ItemMenu(Icons.Default.Notifications, "Notifications")
        ItemMenu(Icons.Default.Storage, "Storage")
        ItemMenu(Icons.Default.Accessibility, "Accessibility")
        ItemMenu(Icons.AutoMirrored.Filled.Help, "Help")
    }
}

@Composable
fun ItemMenu(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(44.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = "Icon Menu", tint = WhiteApp)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = title, color = WhiteApp, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    }
}

@Composable
fun AvatarAccount() {
    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(
                text = "Zeta", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "example@gmail.com", color = Color.White, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    MovieNaoTheme {
        SettingsScreen()
    }
}