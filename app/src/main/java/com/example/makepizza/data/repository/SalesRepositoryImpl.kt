package com.example.makepizza.data.repository

import com.example.makepizza.data.datasource.RemoteSalesDataSource
import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.domain.repository.SalesRepository

class SalesRepositoryImpl(
    private val dataSource: RemoteSalesDataSource
): SalesRepository {
    override suspend fun getSales(): List<SaleResponse> = dataSource.getSalesList()
}