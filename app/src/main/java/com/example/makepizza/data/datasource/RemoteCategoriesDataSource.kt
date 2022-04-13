package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.data.network.ApiServiceApp

class RemoteCategoriesDataSource (
    private val service: ApiServiceApp
) {

    suspend fun getCategoriesList(): List<CategoriesResponse> = service.getCategoriesList()
}