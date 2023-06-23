package com.arturogarciamontoro.sadav.presentation.features.details


data class DetailsState(
    val loading: Boolean = true,
)

sealed class DetailsIntent {
}

sealed class DetailsEvent {

}

