package com.arturogarciamontoro.sadav.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arturogarciamontoro.sadav.presentation.theme.PrimaryVariant

@Composable
fun BottomCustomBar(
    prev: String?,
    next: String?,
    previousClick: (Int) -> Unit,
    nextClick: (Int) -> Unit
) {
    BottomAppBar(backgroundColor = PrimaryVariant, elevation = 15.dp) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val currentPage = remember {
                mutableStateOf(1)
            }
            IconButton(
                enabled = !prev.isNullOrBlank(),
                onClick = {
                    currentPage.value--
                    previousClick(currentPage.value)
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "previous page"
                )
            }

            Text(
                text = currentPage.value.toString(),
            )
            IconButton(
                enabled = !next.isNullOrBlank(),
                onClick = {
                    currentPage.value++
                    nextClick(currentPage.value)
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "next page"
                )
            }

        }
    }
}