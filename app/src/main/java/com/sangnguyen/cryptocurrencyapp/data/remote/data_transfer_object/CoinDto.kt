package com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object

import com.google.gson.annotations.SerializedName
import com.sangnguyen.cryptocurrencyapp.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName(value = "is_active")
    val isActive: Boolean,
    @SerializedName(value = "is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}