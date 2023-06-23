package com.arturogarciamontoro.sadav.presentation.features.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arturogarciamontoro.sadav.core.mvi.composables.EventProcessor
import com.arturogarciamontoro.sadav.domain.model.Result
import com.arturogarciamontoro.sadav.presentation.DefaultNavGraph
import com.arturogarciamontoro.sadav.presentation.features.destinations.DetailsDestination
import com.arturogarciamontoro.sadav.presentation.features.home.components.BottomCustomBar
import com.arturogarciamontoro.sadav.presentation.features.home.components.CharacterCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@DefaultNavGraph(
    start = true
)
@Destination
@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    val state = viewModel.viewState
    Scaffold(
        bottomBar = {
            BottomCustomBar(
                state.info?.prev,
                state.info?.next,
                previousClick = {
                    viewModel.sendIntent(HomeIntent.GetData(it))
                },
                nextClick = {
                    viewModel.sendIntent(HomeIntent.GetData(it))
                },
            )
        },
        content = {
            HomeContent(
                getData = {
                    viewModel.sendIntent(HomeIntent.GetData(1))
                },
                navigate = {
                    viewModel.sendIntent(HomeIntent.ClickCharacter(it))
                },
                loading = state.loading,
                charactersList = state.charactersList
            )
        }
    )
    EventProcessor(viewModelEventDelegate = viewModel) { event ->
        event?.let {
            when (event) {
                HomeEvent.Error -> {}
                is HomeEvent.NavigateToDetails -> {
                    navigator.navigate(DetailsDestination(event.character))
                }
            }
        }
    }
}


@Composable
fun HomeContent(
    loading: Boolean = false,
    getData: () -> Unit,
    navigate: (character: Result) -> Unit,
    charactersList: List<Result?>,
) {
    LaunchedEffect(Unit) {
        getData()
    }
    AnimatedVisibility(
        !loading, enter = fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ), exit = fadeOut()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp
                )
            ) {
                items(charactersList) { character ->
                    character?.let {
                        CharacterCard(character = character) {
                            navigate(it)
                        }
                    }
                }
            }
        }
    }
    AnimatedVisibility(
        loading, enter = fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ), exit = fadeOut()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

