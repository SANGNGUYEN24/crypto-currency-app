package com.sangnguyen.cryptocurrencyapp.domain.use_case.get_coin

import com.sangnguyen.cryptocurrencyapp.common.Resource
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.toCoin
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.toCoinDetail
import com.sangnguyen.cryptocurrencyapp.domain.model.Coin
import com.sangnguyen.cryptocurrencyapp.domain.model.CoinDetail
import com.sangnguyen.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Please check your connection!"))
        }
    }
}