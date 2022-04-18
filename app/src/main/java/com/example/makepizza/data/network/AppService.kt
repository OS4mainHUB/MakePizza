package com.example.makepizza.data.network

import com.example.makepizza.data.model.ContentCategoriesResponse
import com.example.makepizza.data.model.SaleResponse
import retrofit2.http.GET

interface AppService {
    companion object{
        const val BASE_URL = "https://fastapi-pizza.herokuapp.com/"
    }

    @GET("sales")
    suspend fun getSalesList(): List<SaleResponse>

    @GET("content")
    suspend fun getContentCategoriesList(): List<ContentCategoriesResponse>
}