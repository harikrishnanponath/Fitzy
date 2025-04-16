package com.harikrish.fitzy.ui.screens.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.harikrish.fitzy.data.model.NetworkResponse
import com.harikrish.fitzy.data.model.ProductItem
import com.harikrish.fitzy.viewmodel.FitzyViewModel

@Composable
fun RowProducts(
    productResult: NetworkResponse<List<ProductItem>>,
    viewModel: FitzyViewModel,
    title: String,
    navController: NavController
) {

    LaunchedEffect(Unit) {
        viewModel.getAllProducts()
    }

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp),
            color = Color.White)

        TextButton(onClick = {}) {
            Text(
                text = "See All",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )
        }
    }
    when (productResult) {
        is NetworkResponse.Loading -> CircularProgressIndicator()
        is NetworkResponse.Success -> {
            val products = productResult.data
            LazyRow(modifier = Modifier.padding(16.dp))  {
                items(products) { product ->
                    ProductCardView(product, 250.dp){
                        navController.navigate("productDetail/${product.id}")
                    }
                    Spacer(Modifier.size(8.dp))
                }
            }
        }
        is NetworkResponse.Error -> Text("Error: ${(productResult as NetworkResponse.Error).error}", color = Color.Red)
    }
}


