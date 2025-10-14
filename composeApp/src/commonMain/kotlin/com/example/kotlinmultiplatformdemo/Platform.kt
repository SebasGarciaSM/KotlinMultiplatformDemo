package com.example.kotlinmultiplatformdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform