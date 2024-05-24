package com.korugan.composebasics.ui.layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.korugan.composebasics.R

// Horizontal Ve  Vertical Pagerlar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExampleHorizontalPager() {
    val images = listOf(R.drawable.roma, R.drawable.image, R.drawable.roma2)
    val pagerState = rememberPagerState(pageCount = {
        images.size
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
    ) {

        // Horizontal Olarak Kayan Resimler
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            key = { images[it] },
            pageContent = ({ index ->
                Image(
                    painter = painterResource(id = images[index]),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                )
            })
        )

        // Ekranın Alt Tarafta hangi resimde olduğunu gösteren compose codu
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExampleVerticalPage() {
    Box(modifier = Modifier.background(color = Color.White)) {
        val images = listOf(R.drawable.roma, R.drawable.image, R.drawable.roma2)
        val pagerState = rememberPagerState(pageCount = {
            images.size
        })

        // Vertical Olarak Kayan Resimler
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            key = { images[it] },
            pageContent = ({ index ->
                Image(
                    painter = painterResource(id = images[index]),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            })
        )
        // Ekranın Alt Tarafta hangi resimde olduğunu gösteren compose codu
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}