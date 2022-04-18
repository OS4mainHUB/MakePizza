package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.ContentCategoriesResponse
import com.example.makepizza.data.network.AppService

class RemoteContentCategoriesDataSource (
    private val service: AppService
) {
    suspend fun getContentCategories(): List<ContentCategoriesResponse> = service.getContentCategoriesList()
}