package com.arturogarciamontoro.sadav.domain.model

import java.io.Serializable

data class Result(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: Origin?,
    val location: Location?,
    val image: String?,
    val episode: List<String?>?,
    val url: String?,
    val created: String?
) : Serializable {
    data class Origin(
        val name: String?,
        val url: String?
    ) : Serializable

    data class Location(
        val name: String?,
        val url: String?
    ) : Serializable
}