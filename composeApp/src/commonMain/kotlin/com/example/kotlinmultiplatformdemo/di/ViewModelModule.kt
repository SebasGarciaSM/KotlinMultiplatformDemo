package com.example.kotlinmultiplatformdemo.di

import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { PhotosViewModel(get()) }
}