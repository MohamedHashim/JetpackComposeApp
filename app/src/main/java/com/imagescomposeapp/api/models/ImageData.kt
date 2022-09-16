package com.imagescomposeapp.api.models

data class ImageData(
    val id: Int,
    val location: String?,
    val url: String,
    val tags: List<String>,
    var isLiked: Boolean
)
