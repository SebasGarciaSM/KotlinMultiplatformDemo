package com.example.kotlinmultiplatformdemo

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.example.kotlinmultiplatformdemo.data.repositories.PhotosRepository
import com.example.kotlinmultiplatformdemo.data.services.PhotosApiServiceImpl
import com.example.kotlinmultiplatformdemo.ui.views.PhotosView
import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun MainViewController() = ComposeUIViewController {
    val viewModel = remember {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
        val photosApiService = PhotosApiServiceImpl(httpClient)
        val photosRepository = PhotosRepository(photosApiService)
        PhotosViewModel(photosRepository)
    }
    PhotosView(viewModel)
}
