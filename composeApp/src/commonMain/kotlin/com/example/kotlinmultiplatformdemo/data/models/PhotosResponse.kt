package com.example.kotlinmultiplatformdemo.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(
    val photos: List<Photo>
)