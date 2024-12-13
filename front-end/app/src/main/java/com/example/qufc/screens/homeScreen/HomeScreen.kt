package com.example.qufc.screens.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.qufc.screens.homeScreen.components.CoursesRow
import com.example.qufc.screens.homeScreen.components.VideoCarousel


val videos = listOf(
        "Resolvendo Lista de PAA",
        "video 2",
        "video 3",
        "video 4"
    )




@Composable
fun HomeScreen() {


    Surface(color = Color.White) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { VideoCarousel(videos, videos) }
            item { CoursesRow() }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}