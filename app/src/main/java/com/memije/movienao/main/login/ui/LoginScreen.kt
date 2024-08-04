package com.memije.movienao.main.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.movienao.framework.base.Routes
import com.memije.movienao.framework.components.Button
import com.memije.movienao.framework.components.Email
import com.memije.movienao.framework.components.Password
import com.memije.movienao.framework.theme.BlackApp
import com.memije.movienao.framework.theme.BlueApp
import com.memije.movienao.framework.theme.MovieNaoTheme
import com.memije.movienao.framework.theme.WhiteApp

@Composable
fun LoginScreen(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackApp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", color = WhiteApp, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.size(32.dp))
        Email()
        Spacer(modifier = Modifier.size(32.dp))
        Password()
        Spacer(modifier = Modifier.size(32.dp))
        Button("Login", navController)
        Spacer(modifier = Modifier.size(32.dp))
        CopySignUp(navController)
    }
}

@Composable
fun CopySignUp(navController: NavHostController?) {
    Row {
        Text(text = "Haven’t made an account?", color = WhiteApp)
        Spacer(modifier = Modifier.size(6.dp))
        Text(
            text = "Sign Up",
            color = BlueApp,
            modifier = Modifier.clickable { navController?.navigate(Routes.SignUp.route) })
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MovieNaoTheme {
        LoginScreen()
    }
}