package com.example.flipkartmini.datalib.models.network

sealed class NetworkResponse<out O>{
    data class Success<out O>(val data:O): NetworkResponse<O>()
    data class Failure<out O>(val message:String?): NetworkResponse<O>()
}
