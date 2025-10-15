package com.example.kotlinmultiplatformdemo.di

import com.example.kotlinmultiplatformdemo.data.services.IPhotosApiService
import com.example.kotlinmultiplatformdemo.data.services.PhotosApiServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val serviceModule = module {
    singleOf(::PhotosApiServiceImpl) { bind<IPhotosApiService>() }
}