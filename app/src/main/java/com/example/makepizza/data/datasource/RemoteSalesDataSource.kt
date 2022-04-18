package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.data.network.AppService

class RemoteSalesDataSource(
    private val service: AppService
) {
    suspend fun getSalesList(): List<SaleResponse> = service.getSalesList()
}