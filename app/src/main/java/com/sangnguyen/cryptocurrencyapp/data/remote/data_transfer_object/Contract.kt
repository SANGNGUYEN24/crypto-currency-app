package com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object


import com.google.gson.annotations.SerializedName

data class Contract(
    @SerializedName("contract")
    val contract: String,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("type")
    val type: String
)