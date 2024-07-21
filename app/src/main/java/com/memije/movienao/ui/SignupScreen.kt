package com.memije.movienao.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.BlueApp
import com.memije.movienao.ui.theme.MovieNaoTheme
import com.memije.movienao.ui.theme.WhiteApp
import com.memije.movienao.ui.utils.Email
import com.memije.movienao.ui.utils.LoginButton
import com.memije.movienao.ui.utils.Password
import com.memije.movienao.ui.utils.Routes
import com.memije.movienao.ui.utils.getCustomTextFieldColors

@Composable
fun SignupScreen(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackApp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Sign Up", color = WhiteApp, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.size(32.dp))
        Email()
        Spacer(modifier = Modifier.size(32.dp))
        Username()
        Spacer(modifier = Modifier.size(32.dp))
        Password()
        Spacer(modifier = Modifier.size(32.dp))
        LoginButton("Create Account", navController)
        Spacer(modifier = Modifier.size(32.dp))
        CopyLogin(navController)
    }
}

@Composable
fun CopyLogin(navController: NavHostController?) {
    Row {
        Text(text = "Already have an account?", color = WhiteApp)
        Spacer(modifier = Modifier.size(6.dp))
        Text(
            text = "Login",
            color = BlueApp,
            modifier = Modifier.clickable { navController?.navigate(Routes.Login.route) })
    }
}

@Composable
fun Username() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Username") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Person, contentDescription = "Icon Mail"
            )
        },
        supportingText = { Text(text = "Inactive", color = WhiteApp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = getCustomTextFieldColors()
    )
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    MovieNaoTheme {
        SignupScreen()
    }
}