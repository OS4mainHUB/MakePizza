package com.example.makepizza.domain.repository

import com.example.makepizza.data.model.PizzaResponse

interface PizzaRepository {
    suspend fun getPizza(): List<PizzaResponse>
}