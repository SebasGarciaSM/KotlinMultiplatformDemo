package com.example.kotlinmultiplatformdemo.data.repositories

import com.example.kotlinmultiplatformdemo.data.services.PhotosApiService
import com.example.kotlinmultiplatformdemo.domain.interfaces.IPhotosRepository
import com.example.kotlinmultiplatformdemo.domain.models.PhotoModel
import kotlin.collections.emptyList

class PhotosRepository(
    private val api: PhotosApiService
) : IPhotosRepository {
    override suspend fun getAllPhotos(): List<PhotoModel> {
        return try {
            val listOfPhotos = mutableListOf<PhotoModel>()
            val response = api.fetchPhotos()

            response?.let {
                it.photos.forEach { photo ->
                    listOfPhotos.add(
                        PhotoModel(
                            url = photo.url,
                            title = photo.title,
                            user = photo.user,
                            description = photo.description,
                            id = photo.id
                        )
                    )
                }
            }

            listOfPhotos
        } catch (e: Exception) {
            emptyList<PhotoModel>()
        }
    }
}