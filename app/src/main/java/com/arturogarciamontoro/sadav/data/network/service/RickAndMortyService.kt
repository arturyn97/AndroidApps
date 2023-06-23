package com.arturogarciamontoro.sadav.data.network.service

import com.arturogarciamontoro.sadav.data.model.RickAndMortyResponseModel
import com.arturogarciamontoro.sadav.data.network.api.RickAndMortyApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyService @Inject constructor(private val api: RickAndMortyApiClient) {

    suspend fun getCharacters(page: Int): Response<RickAndMortyResponseModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters(page = page)
            response
        }
    }
}