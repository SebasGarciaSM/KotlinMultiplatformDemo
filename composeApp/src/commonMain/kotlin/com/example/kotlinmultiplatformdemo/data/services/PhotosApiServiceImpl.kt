package com.example.kotlinmultiplatformdemo.data.services

import com.example.kotlinmultiplatformdemo.data.models.PhotosResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode

class PhotosApiServiceImpl(
    private val httpClient: HttpClient
) : IPhotosApiService {
    override suspend fun fetchPhotos(): PhotosResponse? {
        val response = httpClient.get("https://api.slingacademy.com/v1/sample-data/photos")
        return when {
            response.status == HttpStatusCode.OK -> {
                response.body<PhotosResponse>()
            }

            else -> null
        }
    }
}