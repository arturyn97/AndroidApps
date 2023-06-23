package com.arturogarciamontoro.sadav.presentation.features.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.arturogarciamontoro.sadav.presentation.theme.subtitleDetails
import com.arturogarciamontoro.sadav.presentation.theme.subtitleDetailsTag

@Composable
fun DataTag(tag: String?, data: String?) {
    Column() {
        Text(
            text = tag.orEmpty(),
            maxLines = 1,
            style = subtitleDetailsTag,
            color = Color.White
        )
        Text(
            text = data.orEmpty(),
            maxLines = 1,
            style = subtitleDetails
        )
    }
}