package com.example.makepizza.data.model

import com.google.gson.annotations.SerializedName

data class SaleResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl") val imageUrl: String
)

data class CategoriesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
