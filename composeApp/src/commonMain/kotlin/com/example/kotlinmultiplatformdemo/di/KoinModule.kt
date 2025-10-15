package com.example.kotlinmultiplatformdemo.di

import org.koin.dsl.module

val appModule = module {
    includes(networkModule, repositoryModule, viewModelModule, serviceModule)
}