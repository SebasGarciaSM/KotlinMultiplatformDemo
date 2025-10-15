package com.example.kotlinmultiplatformdemo

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kotlinmultiplatformdemo.di.appModule
import com.example.kotlinmultiplatformdemo.ui.views.PhotosView
import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

fun MainViewController() = ComposeUIViewController {
    KoinApplication(application = {
        modules(appModule)
    }) {
        val viewModel = koinInject<PhotosViewModel>()
        PhotosView(viewModel)
    }
}
