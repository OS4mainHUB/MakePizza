package com.example.makepizza.data.repository

import com.example.makepizza.data.datasource.RemotePizzaDataSource
import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.domain.repository.PizzaRepository

class PizzaRepositoryImpl (
    private val dataSource: RemotePizzaDataSource
): PizzaRepository {
    override suspend fun getPizza(): List<PizzaResponse> = dataSource.getPizzaList()
}