package com.harikrish.fitzy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harikrish.fitzy.viewmodel.FitzyViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.harikrish.fitzy.ui.screens.components.RowProducts
import com.harikrish.fitzy.ui.screens.components.TopSearchView
import com.harikrish.fitzy.ui.theme.Green800
import com.harikrish.fitzy.ui.theme.Yellow700


@Composable
fun HomeScreen(viewModel: FitzyViewModel = hiltViewModel()) {

    val productResult by viewModel.productResult.collectAsState()
    val searchKey by viewModel.searchKey.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Card(
            modifier = Modifier
                .wrapContentHeight()
                .padding(0.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Green800),
            shape = RoundedCornerShape(
                topEnd = 0.dp, topStart = 0.dp,
                bottomStart = 24.dp, bottomEnd = 24.dp
            )
        ) {
            Spacer(modifier = Modifier.height(52.dp))
            Text(
                text = "Hello Hari",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
                )
            Spacer(modifier = Modifier.height(12.dp))
            TopSearchView(searchKey, viewModel)
            Spacer(Modifier.size(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))
        RowProducts(productResult, viewModel, "Hot Deals")
        Spacer(modifier = Modifier.height(16.dp))
        RowProducts(productResult, viewModel, "Trendy")
    }
}


