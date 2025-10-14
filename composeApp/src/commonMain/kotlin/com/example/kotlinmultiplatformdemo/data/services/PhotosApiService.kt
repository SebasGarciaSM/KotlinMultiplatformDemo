package com.example.kotlinmultiplatformdemo.data.services

import com.example.kotlinmultiplatformdemo.data.models.Photo
import com.example.kotlinmultiplatformdemo.data.models.PhotosResponse

interface PhotosApiService {

    suspend fun fetchPhotos(): PhotosResponse?

}