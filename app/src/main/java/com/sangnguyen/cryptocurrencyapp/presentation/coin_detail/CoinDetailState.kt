package com.sangnguyen.cryptocurrencyapp.presentation.coin_detail

import com.sangnguyen.cryptocurrencyapp.domain.model.Coin
import com.sangnguyen.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
