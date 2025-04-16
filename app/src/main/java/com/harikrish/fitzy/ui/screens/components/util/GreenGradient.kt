package com.harikrish.fitzy.ui.screens.components.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val greenGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF0F0F0F),  // Dark gray/black
        Color(0xFF005600),  // Dark green
        Color(0xFF0A5B29)   // Bright green
    ),
    start = Offset(0f, 0f),
    end = Offset.Infinite
)
