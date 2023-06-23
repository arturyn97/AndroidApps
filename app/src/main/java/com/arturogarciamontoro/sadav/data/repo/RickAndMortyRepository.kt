package com.arturogarciamontoro.sadav.data.repo

import com.arturogarciamontoro.sadav.data.model.RickAndMortyResponseModel
import com.arturogarciamontoro.sadav.data.network.service.RickAndMortyService
import com.arturogarciamontoro.sadav.domain.model.RickAndMortyResponse
import com.arturogarciamontoro.sadav.domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val api: RickAndMortyService,
) {
    fun geCharactersFromApi(page: Int): Flow<Result<RickAndMortyResponse?>> = flow {
        val result: Response<RickAndMortyResponseModel> = api.getCharacters(page)
        emit(Result.success(result.body()?.toDomain()))
    }.catch {
        it.printStackTrace()
        emit(Result.failure(it))
    }
}