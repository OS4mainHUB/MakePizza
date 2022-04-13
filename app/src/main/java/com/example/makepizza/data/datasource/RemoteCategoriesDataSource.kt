package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.data.network.AppService

class RemoteCategoriesDataSource (
    private val service: AppService
) {

    suspend fun getCategoriesList(): List<CategoriesResponse> = service.getCategoriesList()
}