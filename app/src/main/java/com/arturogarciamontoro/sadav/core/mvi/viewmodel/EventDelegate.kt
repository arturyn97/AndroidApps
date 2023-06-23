package com.arturogarciamontoro.sadav.core.mvi.viewmodel

import kotlinx.coroutines.flow.Flow

interface EventDelegate<E> {
    val viewEvents: Flow<E?>
    suspend fun sendEvent(event: E)
    suspend fun resetEvent()
}