package com.example.makepizza.domain.interactor

import com.example.makepizza.data.model.PizzaResponse
import com.example.makepizza.domain.repository.PizzaRepository

class GetPizzaUseCase (
    private val repository: PizzaRepository
) {
    suspend fun execute(): List<PizzaResponse> = repository.getPizza()
}