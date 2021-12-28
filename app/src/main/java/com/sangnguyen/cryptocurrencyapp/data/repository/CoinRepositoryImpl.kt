package com.sangnguyen.cryptocurrencyapp.data.repository

import com.sangnguyen.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.CoinDetailDto
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.CoinDto
import com.sangnguyen.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}