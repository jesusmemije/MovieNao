package com.memije.movienao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.memije.movienao.ui.LoginScreen
import com.memije.movienao.ui.theme.MovieNaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieNaoTheme {
                LoginScreen()
            }
        }
    }
}