package com.example.makepizza.domain.repository

import com.example.makepizza.data.model.CategoriesResponse

interface CategoriesRepository {
    suspend fun getCategories(): List<CategoriesResponse>
}