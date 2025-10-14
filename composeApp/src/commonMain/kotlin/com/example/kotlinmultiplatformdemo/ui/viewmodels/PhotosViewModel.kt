package com.example.kotlinmultiplatformdemo.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmultiplatformdemo.data.repositories.PhotosRepository
import com.example.kotlinmultiplatformdemo.domain.models.PhotoModel
import kotlinx.coroutines.launch

class PhotosViewModel(
    private val repository: PhotosRepository
) : ViewModel() {

    private val _photos = mutableStateListOf<PhotoModel>()
    val photos: List<PhotoModel> = _photos

    fun getPhotos() {
        try {
            viewModelScope.launch {
                _photos.addAll(repository.getAllPhotos())
            }
        } catch (e: Exception) {
            println("Error getting photos: $e")
        }
    }

}