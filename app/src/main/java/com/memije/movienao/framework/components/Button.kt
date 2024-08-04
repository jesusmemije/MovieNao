package com.memije.movienao.framework.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.movienao.framework.base.Routes
import com.memije.movienao.framework.theme.BlackApp
import com.memije.movienao.framework.theme.GreenApp

@Composable
fun Button(name: String, navController: NavHostController?) {
    Button(
        shape = RoundedCornerShape(4.dp),
        onClick = { navController?.navigate(Routes.Home.route) },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenApp, contentColor = BlackApp
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}