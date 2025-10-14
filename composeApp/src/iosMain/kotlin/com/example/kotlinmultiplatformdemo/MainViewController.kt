package com.example.kotlinmultiplatformdemo

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kotlinmultiplatformdemo.ui.views.PhotosView

fun MainViewController() = ComposeUIViewController { PhotosView() }