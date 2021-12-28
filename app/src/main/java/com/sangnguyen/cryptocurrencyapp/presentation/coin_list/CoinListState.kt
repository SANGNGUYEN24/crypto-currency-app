package com.sangnguyen.cryptocurrencyapp.presentation.coin_list

import com.sangnguyen.cryptocurrencyapp.data.repository.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
