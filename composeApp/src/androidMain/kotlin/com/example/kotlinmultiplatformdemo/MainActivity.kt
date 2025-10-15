package com.example.kotlinmultiplatformdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import com.example.kotlinmultiplatformdemo.ui.views.PhotosView
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = koinInject<PhotosViewModel>()
            PhotosView(viewModel = viewModel)
        }
    }
}