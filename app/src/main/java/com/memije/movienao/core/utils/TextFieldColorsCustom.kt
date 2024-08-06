package com.memije.movienao.core.utils

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.memije.movienao.core.theme.GreenApp
import com.memije.movienao.core.theme.WhiteApp

@Composable
fun getTextFieldColorsCustom(): TextFieldColors {
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