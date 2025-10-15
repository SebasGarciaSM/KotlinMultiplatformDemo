package com.example.kotlinmultiplatformdemo.di

import com.example.kotlinmultiplatformdemo.data.repositories.PhotosRepository
import com.example.kotlinmultiplatformdemo.domain.interfaces.IPhotosRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::PhotosRepository) { bind<IPhotosRepository>() }
}