package com.arturogarciamontoro.sadav.data.network.api

import com.arturogarciamontoro.sadav.data.model.RickAndMortyResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RickAndMortyApiClient {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int,
    ): Response<RickAndMortyResponseModel>
}