package com.example.makepizza.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SaleResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl") val imageUrl: String
)

@Parcelize
data class Product(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Float,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("description") val description: String
) : Parcelable

data class ContentCategoriesResponse(
    @SerializedName("title") val title: String,
    @SerializedName("items") val items: List<Product>
)
