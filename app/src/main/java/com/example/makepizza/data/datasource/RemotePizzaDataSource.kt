package com.example.makepizza.data.datasource

import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.data.network.AppService

class RemotePizzaDataSource (
    private val service: AppService
) {

    suspend fun getPizzaList(): List<PizzaResponse> = service.getPizzaList()
}