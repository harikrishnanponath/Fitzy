package com.harikrish.fitzy.ui.screens.components.product

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.harikrish.fitzy.data.model.ProductItem


@SuppressLint("DefaultLocale")
@Composable
fun ProductCardView(product: ProductItem, dp: Dp, productClicked: () -> Unit) {

    val formattedPrice = if (product.price % 1.0 == 0.0)
        "$${product.price.toInt()}"
    else
        String.format("$%.2f", product.price)

    Card(
        modifier = Modifier
            .size(height = dp, width = dp - 50.dp)
            .padding(8.dp)
            .clickable { productClicked() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween // Even spacing
        ) {
            // Product Image
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dp / 2),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = product.title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp))
                        .padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Product Title
            Text(
                text = product.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            // Price
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Price Text
                Text(
                    text = formattedPrice,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )

                // Rating with Star Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.rating.rate.toString(),
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating Star",
                        tint = Color(0xFFFFC107), // Gold color
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
