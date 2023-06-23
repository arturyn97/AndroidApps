package com.arturogarciamontoro.sadav.presentation.features.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.BaseViewModel
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.EventDelegate
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.EventDelegateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : BaseViewModel<DetailsState, DetailsIntent>(),
    EventDelegate<DetailsEvent> by EventDelegateViewModel() {

    override var viewState by mutableStateOf(DetailsState())

    override fun processIntent(intent: DetailsIntent) {
    }
}