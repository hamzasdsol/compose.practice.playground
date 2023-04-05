package com.example.composepractice.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composepractice.R


val fonts = FontFamily(
    Font(R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(R.font.montserrat_light, weight = FontWeight.Light),
    Font(R.font.montserrat_medium, weight = FontWeight.Normal),
    Font(R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(R.font.montserrat_semi_bold, weight = FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    h2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 60.sp,
        letterSpacing = 0.5.sp
    ),

    h1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = 0.5.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)