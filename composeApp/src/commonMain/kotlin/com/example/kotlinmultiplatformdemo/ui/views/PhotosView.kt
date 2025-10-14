package com.example.kotlinmultiplatformdemo.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinmultiplatformdemo.domain.models.PhotoModel
import com.example.kotlinmultiplatformdemo.ui.viewmodels.PhotosViewModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PhotosView(viewModel: PhotosViewModel) {
    LaunchedEffect(Unit) {
        viewModel.getPhotos()
    }

    val photos = remember { viewModel.photos }

    PhotosView(
        photos = photos
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotosView(
    photos: List<PhotoModel>
) {

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Kotlin Multiplatform Demo") }
                )
            }
        ) { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                items(photos) { photo ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            KamelImage(
                                resource = { asyncPainterResource(photo.url) },
                                contentDescription = "",
                                alignment = Alignment.Center,
                                contentScale = ContentScale.Crop,
                                alpha = DefaultAlpha,
                                contentAlignment = Alignment.Center,
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.BottomStart)
                                    .background(color = Color(0x80000000))
                                    .padding(16.dp),
                                verticalArrangement = Arrangement.Bottom,
                            ) {
                                Text(
                                    photo.title, style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        color = Color.White
                                    )
                                )
                                Text(
                                    photo.description,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PhotosViewPreview() {
    PhotosView(
        photos = listOf(
            PhotoModel(
                url = "composeApp/src/commonMain/composeResources/images/animal.jpg",
                title = "Title",
                user = "",
                description = "This is a description",
                id = ""
            )
        )
    )
}