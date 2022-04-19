package com.example.makepizza.data.repository

import com.example.makepizza.data.datasource.RemoteContentCategoriesDataSource
import com.example.makepizza.data.model.ContentCategoriesResponse
import com.example.makepizza.domain.repository.ContentCategoriesRepository

class ContentCategoriesRepositoryImpl (
    private val dataSource: RemoteContentCategoriesDataSource
): ContentCategoriesRepository {
    override suspend fun getContentCategories(): List<ContentCategoriesResponse> = dataSource.getContentCategories()
}