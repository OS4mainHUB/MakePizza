package com.example.makepizza.domain.interactor

import com.example.makepizza.data.model.CategoriesResponse
import com.example.makepizza.domain.repository.CategoriesRepository

class GetCategoriesUseCase(
    private val repository: CategoriesRepository
) {
    suspend fun execute(): List<CategoriesResponse> = repository.getCategories()
}