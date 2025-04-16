package com.harikrish.fitzy.ui.screens.components.product

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.harikrish.fitzy.viewmodel.FitzyViewModel

@Composable
fun TopSearchView(searchKey: String, viewModel: FitzyViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(
            modifier =  Modifier.weight(1f),
            value = searchKey,
            onValueChange = { viewModel.onSearchKeyChange(it) },
            placeholder = { Text("Search") },
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(Modifier.size(8.dp))
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Icon",
            tint = Color.White
        )

    }

}