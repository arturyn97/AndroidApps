package com.arturogarciamontoro.sadav.core.mvi.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.arturogarciamontoro.sadav.core.mvi.viewmodel.EventDelegate

@Composable
fun <E> EventProcessor(
    viewModelEventDelegate: EventDelegate<E>,
    content: @Composable (E?) -> Unit
) {
    val value = viewModelEventDelegate.viewEvents.collectAsState(initial = null).value
    content(value)
    LaunchedEffect(value) {
        if (value != null) {
            viewModelEventDelegate.resetEvent()
        }
    }
}