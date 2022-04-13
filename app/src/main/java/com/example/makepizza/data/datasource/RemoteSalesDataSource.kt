package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.SaleResponse
import com.example.makepizza.data.network.ApiServiceApp

class RemoteSalesDataSource(
    private val service: ApiServiceApp
) {

    suspend fun getSalesList(): List<SaleResponse> = service.getSalesList()
}