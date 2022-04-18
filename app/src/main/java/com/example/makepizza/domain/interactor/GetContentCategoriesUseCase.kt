package com.example.makepizza.domain.interactor

import com.example.makepizza.data.model.ContentCategoriesResponse
import com.example.makepizza.domain.repository.ContentCategoriesRepository

class GetContentCategoriesUseCase (
    private val repository: ContentCategoriesRepository
) {
    suspend fun execute(): List<ContentCategoriesResponse> = repository.getContentCategories()
}