package com.example.kotlinmultiplatformdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinmultiplatformdemo.data.repositories.PhotosRepository
import com.example.kotlinmultiplatformdemo.data.services.PhotosApiServiceImpl
import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import com.example.kotlinmultiplatformdemo.ui.views.PhotosView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            PhotosView(
                viewModel = PhotosViewModel(
                    repository = PhotosRepository(
                        api = PhotosApiServiceImpl()
                    )
                )
            )
        }
    }
}