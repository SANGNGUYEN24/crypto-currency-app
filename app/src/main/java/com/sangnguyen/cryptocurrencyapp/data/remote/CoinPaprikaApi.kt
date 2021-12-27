package com.sangnguyen.cryptocurrencyapp.data.remote

import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.CoinDetailDto
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET(value = "v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET(value = "v1/coin/{coinId}")
    suspend fun getCoinById(@Path(value = "coinId") coinId: String): CoinDetailDto
}