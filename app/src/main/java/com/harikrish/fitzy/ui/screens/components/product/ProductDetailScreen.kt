package com.harikrish.fitzy.ui.screens.components.product

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.harikrish.fitzy.data.Constants.BROWN_GRADIENT
import com.harikrish.fitzy.ui.theme.Green400
import com.harikrish.fitzy.ui.theme.Green800
import com.harikrish.fitzy.viewmodel.FitzyViewModel
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Heart
import compose.icons.fontawesomeicons.solid.Save

@Composable
fun ProductDetailScreen(
    productId: Int?,
    navController: NavController,
    viewModel: FitzyViewModel = hiltViewModel()
) {
    LaunchedEffect(productId) {
        productId?.let { viewModel.getProductById(it) }
    }

    val product by viewModel.product.collectAsState()

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green800
                    )
                ) {
                    Text(
                        text = "Add to Cart",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        },
        topBar = {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Back Icon",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Heart,
                        contentDescription = "Like Icon",
                        tint = Color(0xFFBD0E00),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    ) { paddingValues ->
        if (product == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BROWN_GRADIENT)
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BROWN_GRADIENT)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {


                    Spacer(modifier = Modifier.height(16.dp))

                    // Product Image Card
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        AsyncImage(
                            model = product?.image,
                            contentDescription = product?.title,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = product?.category ?: "",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = product?.title ?: "",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Price and Rating
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$${product?.price}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = product?.rating?.rate.toString(),
                                color = Color.LightGray,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Rating Star",
                                tint = Color(0xFFFFC107),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Product Info",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = product?.description ?: "",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.height(80.dp)) // To prevent content from hiding behind bottom button
                }
            }
        }
    }
}
