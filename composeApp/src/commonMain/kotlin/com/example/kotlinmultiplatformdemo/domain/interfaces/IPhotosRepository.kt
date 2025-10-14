package com.example.kotlinmultiplatformdemo.domain.interfaces

import com.example.kotlinmultiplatformdemo.domain.models.PhotoModel

interface IPhotosRepository {

    suspend fun getAllPhotos(): List<PhotoModel>

}