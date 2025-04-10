package com.harikrish.fitzy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harikrish.fitzy.viewmodel.FitzyViewModel
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun HomeScreen(viewModel: FitzyViewModel = hiltViewModel()){

    val productResult by viewModel.productResult.collectAsState()
    val searchKey by viewModel.searchKey.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        ){
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchKey,
                onValueChange = { viewModel.onSearchKeyChange(it) },
                label = {
                    Text("Search")
                })
            Spacer(modifier = Modifier.height(16.dp))
            RowProducts(productResult, viewModel, "Hot Deals")
            Spacer(modifier = Modifier.height(16.dp))
            RowProducts(productResult, viewModel, "Trendy")
        }
    }

}

