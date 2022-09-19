package com.example.flipkartmini.datalib.repositories

import com.example.flipkartmini.datalib.models.Product
import com.example.flipkartmini.datalib.models.network.NetworkResponse
import javax.inject.Inject


class ProductRepo @Inject constructor() {
    fun getProducts(): NetworkResponse<List<Product>> {
        return NetworkResponse.Success(
            mutableListOf<Product>().apply {
                for (i in 0..50 step 3) {
                    add(
                        Product(
                            "$i",
                            null,
                            brandName = "Nike",
                            5000,
                            "Mesh Sports Shoes Walking Running Shoes",
                            rating = 4f
                        )
                    )
                    add(
                        Product(
                            "${i + 1}",
                            null,
                            brandName = "asics",
                            8000,
                            "GEL-KINSEI BLAST LE Running Shoes For Men",
                            rating = 5f
                        )
                    )
                    add(
                        Product(
                            "${i + 2}",
                            null,
                            brandName = "Nike",
                            3000,
                            "Winflo 8 Running Shoes For Men",
                            rating = 3.5f
                        )
                    )
                }
            }
        )
    }
}