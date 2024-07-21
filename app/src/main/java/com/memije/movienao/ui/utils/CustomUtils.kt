package com.memije.movienao.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memije.movienao.ui.theme.BlackApp
import com.memije.movienao.ui.theme.GreenApp
import com.memije.movienao.ui.theme.WhiteApp

@Composable
fun Email() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Email") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Mail, contentDescription = "Icon Mail"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = getCustomTextFieldColors()
    )
}

@Composable
fun Password() {

    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Password") },
        colors = getCustomTextFieldColors(),
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock, contentDescription = "Icon Security"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Show password")
            }
        },
        supportingText = { Text(text = "Inactive", color = WhiteApp) },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun LoginButton(name: String) {
    Button(
        shape = RoundedCornerShape(4.dp),
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenApp, contentColor = BlackApp
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun getCustomTextFieldColors(): TextFieldColors {
    return OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = WhiteApp,
        unfocusedPlaceholderColor = WhiteApp,
        unfocusedContainerColor = Color.Transparent,
        unfocusedLeadingIconColor = GreenApp,
        unfocusedTrailingIconColor = WhiteApp,
        unfocusedLabelColor = WhiteApp,
        focusedBorderColor = GreenApp,
        focusedPlaceholderColor = GreenApp,
        focusedContainerColor = Color.Transparent,
        focusedLeadingIconColor = GreenApp,
        focusedTrailingIconColor = GreenApp,
        focusedLabelColor = GreenApp
    )
}