package com.arturogarciamontoro.sadav.presentation.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.arturogarciamontoro.sadav.domain.model.Result
import com.arturogarciamontoro.sadav.presentation.theme.PrimaryColor
import com.arturogarciamontoro.sadav.presentation.theme.PrimaryVariant
import com.arturogarciamontoro.sadav.presentation.theme.name
import com.arturogarciamontoro.sadav.presentation.theme.subtitle


@Composable
fun CharacterCard(character: Result, click: () -> Unit) {
    Card(
        modifier = Modifier.clickable { click() },
        backgroundColor = PrimaryColor,
        elevation = 16.dp,
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            AsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                model = character.image,
                contentDescription = "Character image"
            )
            Text(text = character.name.orEmpty(), maxLines = 1, style = name, color = Color.White)
            Text(
                text = character.status + "-" + character.species,
                maxLines = 1,
                style = subtitle,
                color = PrimaryVariant
            )
        }
    }
}