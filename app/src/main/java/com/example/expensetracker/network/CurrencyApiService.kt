package com.example.expensetracker.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

data class CurrencyResponse(val rates: Map<String, Double>)

interface CurrencyApiService {
    @GET("latest.json")
    suspend fun getRates(
        @Query("app_id") appId: String,
        @Query("symbols") symbols: String = "USD,EUR"
    ): Response<CurrencyResponse>
}
