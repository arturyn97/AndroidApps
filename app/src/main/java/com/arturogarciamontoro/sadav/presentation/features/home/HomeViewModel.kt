package com.arturogarciamontoro.sadav.presentation.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.BaseViewModel
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.EventDelegate
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.EventDelegateViewModel
import com.arturogarciamontoro.sadav.data.repo.RickAndMortyRepository
import com.arturogarciamontoro.sadav.domain.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
) : BaseViewModel<HomeState, HomeIntent>(), EventDelegate<HomeEvent> by EventDelegateViewModel() {

    override var viewState by mutableStateOf(HomeState())


    override fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.GetData -> {
                getData(intent.page)
            }

            is HomeIntent.ClickCharacter -> {
                navigate(intent.character)
            }
        }
    }

    private fun getData(page: Int = 1) {
        viewModelScope.launch(Dispatchers.IO) {
            viewState = viewState.copy(loading = true)
            rickAndMortyRepository.geCharactersFromApi(page).collect {
                if (it.getOrNull() == null) {
                    sendEvent(HomeEvent.Error)
                } else {
                    viewState = viewState.copy(
                        loading = false,
                        info = it.getOrNull()?.info,
                        charactersList = it.getOrNull()?.results.orEmpty()
                    )
                }
            }
        }
    }

    private fun navigate(character: Result) {
        viewModelScope.launch(Dispatchers.IO) {
            sendEvent(HomeEvent.NavigateToDetails(character))
        }
    }
}