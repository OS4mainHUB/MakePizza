package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.data.network.ApiServiceApp

class RemotePizzaDataSource (
    private val service: ApiServiceApp
) {

    suspend fun getPizzaList(): List<PizzaResponse> = service.getPizzaList()
}