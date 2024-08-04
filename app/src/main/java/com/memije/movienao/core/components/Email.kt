package com.memije.movienao.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.memije.movienao.core.utils.getCustomTextFieldColors

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