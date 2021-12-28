package com.sangnguyen.cryptocurrencyapp.presentation.coin_detail

import com.sangnguyen.cryptocurrencyapp.data.repository.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
