package com.arturogarciamontoro.sadav.domain.model

import com.arturogarciamontoro.sadav.data.model.RickAndMortyResponseModel

data class RickAndMortyResponse(
    val info: Info?,
    val results: List<Result?>?
)

fun RickAndMortyResponseModel.toDomain() = RickAndMortyResponse(
    info = info,
    results = results
)