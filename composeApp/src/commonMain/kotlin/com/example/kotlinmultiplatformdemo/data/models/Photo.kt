package com.example.kotlinmultiplatformdemo.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val url: String,
    val title: String,
    val user: String,
    val description: String,
    val id: String,
)
