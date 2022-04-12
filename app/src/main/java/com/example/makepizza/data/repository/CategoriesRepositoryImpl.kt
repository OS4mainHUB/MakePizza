package com.example.makepizza.data.repository

import com.example.makepizza.data.datasource.RemoteCategoriesDataSource
import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.domain.repository.CategoriesRepository

class CategoriesRepositoryImpl(
    private val dataSource: RemoteCategoriesDataSource
): CategoriesRepository {
    override suspend fun getCategories(): List<CategoriesResponse> = dataSource.getCategoriesList()
}