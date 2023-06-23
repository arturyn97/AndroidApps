package com.arturogarciamontoro.sadav.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arturogarciamontoro.sadav.R

val myCustomFont = FontFamily(
    Font(R.font.sourcedanspro_light, FontWeight.Light),
    Font(R.font.sourcesanspro_regular, FontWeight.Normal),
    Font(R.font.sourcesanspro_semibold, FontWeight.SemiBold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val name = TextStyle(
    fontFamily = myCustomFont,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp
)
val titleDetails = TextStyle(
    fontFamily = myCustomFont,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp
)

val subtitle = TextStyle(
    fontFamily = myCustomFont,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp
)
val subtitleDetails = TextStyle(
    fontFamily = myCustomFont,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp
)
val subtitleDetailsTag = TextStyle(
    fontFamily = myCustomFont,
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp
)