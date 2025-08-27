package com.example.expensetracker.network

class CurrencyRepository(private val api: CurrencyApiService) {
    suspend fun getUsdToEurRate(appId: String): Double {
        val response = api.getRates(appId)
        return response.body()?.rates?.get("EUR") ?: 1.0
    }
}
