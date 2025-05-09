package com.harikrish.fitzy.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harikrish.fitzy.data.api.FitzyApi
import com.harikrish.fitzy.data.model.NetworkResponse
import com.harikrish.fitzy.data.model.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FitzyViewModel @Inject constructor(
    private val api: FitzyApi
) : ViewModel() {

    private val _productResult = MutableStateFlow<NetworkResponse<List<ProductItem>>>(NetworkResponse.Loading)
    val productResult: StateFlow<NetworkResponse<List<ProductItem>>> = _productResult

    private val _searchKey = MutableStateFlow("")
    val searchKey : StateFlow<String> = _searchKey

    private val _product = MutableStateFlow<ProductItem?>(null)
    val product: MutableStateFlow<ProductItem?> = _product

    fun getAllProducts() {
        viewModelScope.launch {
            _productResult.value = NetworkResponse.Loading
            try {
                val response = api.getAllProducts()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _productResult.value = NetworkResponse.Success(it)
                    } ?: run {
                        _productResult.value = NetworkResponse.Error("Empty body")
                    }
                } else {
                    _productResult.value = NetworkResponse.Error("Error ${response.code()}")
                }
            } catch (e: Exception) {
                _productResult.value = NetworkResponse.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun getProductById(id: Int) {
        viewModelScope.launch {
            try{
                val productItem = api.getProductById(id)
                _product.value = productItem.body()
            }
            catch (e: Exception){
                _product.value = null
            }

        }
    }

    fun onSearchKeyChange(newKey: String) {
        _searchKey.value = newKey
    }
}