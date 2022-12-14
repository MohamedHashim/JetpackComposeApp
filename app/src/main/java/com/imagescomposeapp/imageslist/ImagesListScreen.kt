package com.imagescomposeapp.imageslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun ImagesListScreen(
    imagesViewModel: ImagesViewModel,
    onImageClicked: (Int) -> Unit
) {
    when (val uiState = imagesViewModel.uiState.collectAsState().value) {
        ImagesUiState.Loading ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        is ImagesUiState.Success -> {
            Column {
                SearchView {
                    imagesViewModel.searchImages(it)
                }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3)
                ) {
                    items(uiState.images) {
                        Image(
                            painter = rememberImagePainter(it.url),
                            contentDescription = null,
                            modifier = Modifier
                                .size(128.dp)
                                .padding(8.dp)
                                .clickable {
                                    println(it)
                                    onImageClicked(it.id)
                                },
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        is ImagesUiState.Error -> {
        }
    }
}
