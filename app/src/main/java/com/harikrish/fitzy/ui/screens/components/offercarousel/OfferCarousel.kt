package com.harikrish.fitzy.ui.screens.components.offercarousel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun OfferCarousel(
    @DrawableRes imageList: List<Int>
) {

    val pagerState = rememberPagerState(pageCount = { imageList.size })

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val next = (pagerState.currentPage + 1) % imageList.size
            pagerState.animateScrollToPage(next)
        }
    }

    Column(
          modifier = Modifier
              .fillMaxWidth()
              .height(180.dp),
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Card (
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            ){
                Image(
                    painter = painterResource(id = imageList[page]),
                    contentDescription = "offer",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }

        }
    }
}