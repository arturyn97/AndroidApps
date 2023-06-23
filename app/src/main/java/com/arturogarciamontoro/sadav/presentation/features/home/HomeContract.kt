package com.arturogarciamontoro.sadav.presentation.features.home

import com.arturogarciamontoro.sadav.domain.model.Info
import com.arturogarciamontoro.sadav.domain.model.Result

data class HomeState(
    val loading: Boolean = true,
    val info: Info? = null,
    val charactersList: List<Result?> = emptyList(),
)

sealed class HomeIntent {
    data class GetData(val page: Int) : HomeIntent()
    data class ClickCharacter(val character: Result) : HomeIntent()
}

sealed class HomeEvent {
    object Error : HomeEvent()
    data class NavigateToDetails(val character: Result) : HomeEvent()
}
