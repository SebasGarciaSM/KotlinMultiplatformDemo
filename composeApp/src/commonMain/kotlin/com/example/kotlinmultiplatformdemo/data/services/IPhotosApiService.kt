package com.example.kotlinmultiplatformdemo.data.services

import com.example.kotlinmultiplatformdemo.data.models.PhotosResponse

interface IPhotosApiService {

    suspend fun fetchPhotos(): PhotosResponse?

}