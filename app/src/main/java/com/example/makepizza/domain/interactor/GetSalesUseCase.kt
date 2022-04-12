package com.example.makepizza.domain.interactor

import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.domain.repository.SalesRepository

class GetSalesUseCase(
    private val repository: SalesRepository
) {
    suspend fun execute(): List<SaleResponse> = repository.getSales()
}