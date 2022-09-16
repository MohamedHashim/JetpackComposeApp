package com.imagescomposeapp.imagedetails

import com.imagescomposeapp.api.models.ImageData

sealed class ImageDetailsUiState {

    object Loading : ImageDetailsUiState()

    data class Success(
        val imageData: ImageData
    ) : ImageDetailsUiState()

    data class Error(
        val errorMessage: String
    ) : ImageDetailsUiState()
}
