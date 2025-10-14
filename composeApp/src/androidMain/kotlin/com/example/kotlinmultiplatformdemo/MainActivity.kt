package com.example.kotlinmultiplatformdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinmultiplatformdemo.data.repositories.PhotosRepository
import com.example.kotlinmultiplatformdemo.data.services.PhotosApiServiceImpl
import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import com.example.kotlinmultiplatformdemo.ui.views.PhotosView
import com.example.kotlinmultiplatformdemo.ui.views.PhotosViewContent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val httpClient = HttpClient(CIO) {
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

        setContent {
            PhotosView(
                viewModel = PhotosViewModel(
                    repository = PhotosRepository(
                        api = PhotosApiServiceImpl(httpClient)
                    )
                )
            )
        }
    }
}