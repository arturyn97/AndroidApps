package com.arturogarciamontoro.sadav.data.model

import com.arturogarciamontoro.sadav.domain.model.Info
import com.arturogarciamontoro.sadav.domain.model.Result

data class RickAndMortyResponseModel(
    val info: Info?,
    val results: List<Result?>?
)