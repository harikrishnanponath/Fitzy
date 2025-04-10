package com.harikrish.fitzy.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.harikrish.fitzy.data.model.NetworkResponse
import com.harikrish.fitzy.data.model.ProductItem
import com.harikrish.fitzy.viewmodel.FitzyViewModel

@Composable
fun RowProducts(
    productResult: NetworkResponse<List<ProductItem>>,
    viewModel: FitzyViewModel,
    title: String) {
    LaunchedEffect(Unit) {
        viewModel.getAllProducts()
    }

    Text(text = title, fontWeight = FontWeight.Bold)
    Spacer(Modifier.size(12.dp))

    when (productResult) {
        is NetworkResponse.Loading -> CircularProgressIndicator()
        is NetworkResponse.Success -> {
            val products = (productResult as NetworkResponse.Success).data
            LazyRow  {
                items(products) { product ->
                    ProductCardView(product, 180.dp)

                }
            }
        }
        is NetworkResponse.Error -> Text("Error: ${(productResult as NetworkResponse.Error).error}", color = Color.Red)
    }
}

