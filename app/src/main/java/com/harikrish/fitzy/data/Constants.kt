package com.harikrish.fitzy.data

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.harikrish.fitzy.R

object Constants {
    val IMAGE_LIST = listOf(
        R.drawable.offer1,
        R.drawable.offer2,
        R.drawable.offer3,
        R.drawable.offer6,
        R.drawable.offer5,

        )

    val GREEN_GRADIENT = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0F0F0F),  // Dark gray/black
            Color(0xFF053B05),  // Dark green
            Color(0xFF005B1E)   // Bright green
        ),
        start = Offset(1f, 0.5f),
        end = Offset.Infinite
    )

    val PURPLE_GRADIENT = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0F0F0F),  // Dark gray/black
            Color(0xFF350141),  // Dark green
            Color(0xFF810393)   // Bright green
        ),
        start = Offset(0f, 0f),
        end = Offset.Infinite
    )

    val BROWN_GRADIENT = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0F0F0F),  // Dark gray/black
            Color(0xFF491B0E),  // Dark green
            Color(0xFF502F22)   // Bright green
        ),
        start = Offset(0f, 0f),
        end = Offset.Infinite
    )

}