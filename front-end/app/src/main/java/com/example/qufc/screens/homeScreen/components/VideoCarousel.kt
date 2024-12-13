package com.example.qufc.screens.homeScreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.qufc.R
import com.example.qufc.screens.loginRegister.register.fontEsteban

@Composable
fun VideoCarousel(videos: List<String>, titles: List<String>) {
    // State for tracking the current page
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { videos.size })

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Video Player Carousel
        Text(
            text = "Destaques da Semana",
            color = colorResource(R.color.bgColor),
            fontSize = 20.sp,
            fontFamily = fontEsteban,
            modifier = Modifier.align(Alignment.Start)
                .padding(start = 15.dp)
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(180.dp)
        ) { page ->
            Surface(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .fillMaxSize(),
                color = Color.LightGray // Placeholder for video
            ) {
                Text(
                    text = "Video Placeholder ${page + 1}",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Title for the current video
        Text(
            text = titles[pagerState.currentPage],
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = fontEsteban,
            modifier = Modifier.padding(start = 25.dp)
                .align(Alignment.Start)
        )


        Spacer(modifier = Modifier.height(8.dp))
// Navigation Dots
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(videos.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .size(33.dp, 17.dp) // Tamanho maior para o selecionado
                        .padding(4.dp)
                        .background(
                            color = if (isSelected) colorResource(R.color.bgColor) else Color.Gray,
                            shape = CircleShape
                        )
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun VideoCarouselPreview() {
    val videos = listOf("Video1", "Video2", "Video3")
    val titles = listOf("Resolvendo lista de PAA", "Tutorial Kotlin", "Introdução ao Compose")
    VideoCarousel(videos = videos, titles = titles)
}
