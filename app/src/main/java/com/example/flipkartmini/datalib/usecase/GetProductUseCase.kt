package com.example.flipkartmini.datalib.usecase

import com.example.flipkartmini.datalib.models.Product
import com.example.flipkartmini.datalib.models.network.NetworkResponse
import com.example.flipkartmini.datalib.repositories.ProductRepo
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val repo: ProductRepo) {
    suspend fun process():NetworkResponse<List<Product>> = repo.getProducts()
}