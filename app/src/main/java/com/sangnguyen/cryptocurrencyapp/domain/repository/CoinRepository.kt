package com.sangnguyen.cryptocurrencyapp.domain.repository

import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.CoinDetailDto
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}