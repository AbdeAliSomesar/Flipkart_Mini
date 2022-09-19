package com.example.flipkartmini.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flipkartmini.datalib.models.Product
import com.example.flipkartmini.datalib.models.network.NetworkResponse
import com.example.flipkartmini.datalib.usecase.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductUseCase: GetProductUseCase)
    : ViewModel() {

    val adapter by lazy{
        ProductAdapter()
    }
    val products = MutableLiveData<List<Product>?>()
    fun getProducts(onFailure: ((message:String?) -> Unit)? = null) {
        viewModelScope.launch {
            when (val response = getProductUseCase.process()) {
                is NetworkResponse.Success -> products.value = response.data
                is NetworkResponse.Failure-> onFailure?.invoke(response.message)
            }
        }
    }
}