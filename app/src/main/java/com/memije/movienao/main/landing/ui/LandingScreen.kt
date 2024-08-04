package com.memije.movienao.main.landing.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.movienao.R
import com.memije.movienao.core.theme.BlackApp
import com.memije.movienao.core.theme.GreenApp
import com.memije.movienao.core.theme.MovieNaoTheme
import com.memije.movienao.core.base.Routes

@Composable
fun LandingScreen(navController: NavHostController? = null) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(id = R.drawable.landing),
            contentDescription = "Landing",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        BoxInfo(navController)
    }
}

@Composable
fun BoxInfo(navController: NavHostController?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .alpha(0.9f)
            .background(BlackApp, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(32.dp))
        ContentTextInfo()
        Spacer(modifier = Modifier.size(8.dp))
        ContentButtonActions(navController)
    }
}

@Composable
fun ContentButtonActions(navController: NavHostController?) {
    Button(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.fillMaxWidth(),
        onClick = { navController?.navigate(Routes.Login.route) },
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenApp, contentColor = BlackApp
        )
    ) {
        Text(
            text = "Login",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
    Spacer(modifier = Modifier.size(8.dp))
    Button(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.fillMaxWidth(),
        onClick = { navController?.navigate(Routes.SignUp.route) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent, contentColor = GreenApp
        ),
        border = BorderStroke(1.dp, GreenApp)
    ) {
        Text(
            text = "Sign Up",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Composable
fun ContentTextInfo() {
    Text(
        text = "Watch movies anytime anywhere",
        color = White,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.size(8.dp))
    Text(
        text = "Explore a vast collection of blockbuster movies, timeless classics, and the latest releases.",
        color = White,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    MovieNaoTheme {
        LandingScreen()
    }
}