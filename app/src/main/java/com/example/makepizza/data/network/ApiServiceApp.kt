package com.example.makepizza.data.network

import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.data.model.SaleResponse
import retrofit2.http.GET

interface ApiServiceApp {
    companion object{
        const val BASE_URL = "https://fastapi-pizza.herokuapp.com/"
    }

    @GET("sales")
    suspend fun getSalesList(): List<SaleResponse>

    @GET("categories")
    suspend fun getCategoriesList(): List<CategoriesResponse>

    @GET("pizza")
    suspend fun getPizzaList(): List<PizzaResponse>
}