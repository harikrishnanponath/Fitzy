package com.harikrish.fitzy.data.api


import com.harikrish.fitzy.data.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FitzyApi {

    @GET("/products")
    suspend fun getAllProducts() : Response<List<ProductItem>>

    @GET("/products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response<ProductItem>
}