package com.example.flipkartmini.datalib.models

data class Product(
    val id: String? = null,
    val imageUrl: String? = null,
    val brandName: String = "",
    val amount: Int? = null,
    val description: String = "",
    val saved: Boolean = false,
    val rating: Float = 0f
)
