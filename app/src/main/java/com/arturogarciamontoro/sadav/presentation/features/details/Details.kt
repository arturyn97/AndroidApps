package com.arturogarciamontoro.sadav.presentation.features.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.arturogarciamontoro.sadav.R
import com.arturogarciamontoro.sadav.domain.model.Result
import com.arturogarciamontoro.sadav.presentation.features.details.components.DataTag
import com.arturogarciamontoro.sadav.presentation.features.details.components.EpisodeCard
import com.arturogarciamontoro.sadav.presentation.theme.PrimaryColor
import com.arturogarciamontoro.sadav.presentation.theme.PrimaryVariant
import com.arturogarciamontoro.sadav.presentation.theme.subtitleDetailsTag
import com.arturogarciamontoro.sadav.presentation.theme.titleDetails
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun Details(
    viewModel: DetailsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    character: Result,
) {
    val state = viewModel.viewState

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = PrimaryVariant) {
                IconButton(onClick = { navigator.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back button")
                }
            }
        },
        content = { DetailsContent(character) }
    )
}

@Composable
fun DetailsContent(character: Result) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(PrimaryColor)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.Crop,
                model = character.image,
                contentDescription = "Character image"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .background(color = PrimaryVariant, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = character.name.orEmpty(),
                maxLines = 1,
                style = titleDetails,
                color = Color.White
            )
            DataTag(stringResource(id = R.string.status), character.status)
            DataTag(stringResource(id = R.string.species), character.species)
            DataTag(stringResource(id = R.string.type), character.type)
            DataTag(stringResource(id = R.string.gender), character.gender)
            DataTag(stringResource(id = R.string.origin), character.origin?.name)
            DataTag(stringResource(id = R.string.location), character.location?.name)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Text(
                text = stringResource(id = R.string.episodes),
                maxLines = 1,
                style = subtitleDetailsTag,
                color = Color.White
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                character.episode?.forEach {
                    EpisodeCard(it?.split("/")?.last())
                }
            }
        }
    }
}
