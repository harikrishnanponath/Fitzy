package com.harikrish.fitzy.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harikrish.fitzy.viewmodel.FitzyViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harikrish.fitzy.R
import com.harikrish.fitzy.data.Constants.BROWN_GRADIENT
import com.harikrish.fitzy.data.Constants.IMAGE_LIST
import com.harikrish.fitzy.ui.screens.components.product.RowProducts
import com.harikrish.fitzy.ui.screens.components.product.TopSearchView
import com.harikrish.fitzy.ui.screens.components.offercarousel.OfferCarousel
import com.harikrish.fitzy.ui.theme.FitzyTheme


@Composable
fun HomeScreen(viewModel: FitzyViewModel = hiltViewModel(), navController: NavController) {

    val poppinsFontFamily = FontFamily(
        Font(R.font.gothic),  // Regular font weight
        Font(R.font.gothic, FontWeight.Bold)  // Bold font weight
    )

    val productResult by viewModel.productResult.collectAsState()
    val searchKey by viewModel.searchKey.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BROWN_GRADIENT)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .padding(0.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.Transparent),
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Hello Hari",
                fontSize = 32.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            TopSearchView(searchKey, viewModel)
            Spacer(Modifier.size(12.dp))
        }
        OfferCarousel(IMAGE_LIST)
        Spacer(Modifier.size(12.dp))
        RowProducts(productResult, viewModel, "Hot Deals", navController)
        RowProducts(productResult, viewModel, "Trendy", navController)
    }
}





