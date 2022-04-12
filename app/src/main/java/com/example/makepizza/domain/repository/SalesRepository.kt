package com.example.makepizza.domain.repository

import com.example.makepizza.data.model.SaleResponse

interface SalesRepository {
    suspend fun getSales(): List<SaleResponse>
}