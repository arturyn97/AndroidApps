package com.arturogarciamontoro.sadav.presentation.features.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arturogarciamontoro.sadav.presentation.theme.PrimaryVariant
import com.arturogarciamontoro.sadav.presentation.theme.titleDetails

@Composable
fun EpisodeCard(number: String?) {
    Card(
        modifier = Modifier.padding(8.dp).clickable { },
        backgroundColor = PrimaryVariant,
        elevation = 6.dp,
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = number.orEmpty(),
            maxLines = 1,
            style = titleDetails,
            color = Color.White
        )
    }
}