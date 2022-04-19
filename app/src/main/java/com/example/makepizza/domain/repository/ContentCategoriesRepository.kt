package com.example.makepizza.domain.repository

import com.example.makepizza.data.model.ContentCategoriesResponse

interface ContentCategoriesRepository {
    suspend fun getContentCategories(): List<ContentCategoriesResponse>
}