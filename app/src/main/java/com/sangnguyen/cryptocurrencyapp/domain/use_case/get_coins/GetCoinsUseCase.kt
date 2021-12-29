package com.sangnguyen.cryptocurrencyapp.domain.use_case.get_coins

import com.sangnguyen.cryptocurrencyapp.common.Resource
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.toCoin
import com.sangnguyen.cryptocurrencyapp.data.repository.model.Coin
import com.sangnguyen.cryptocurrencyapp.domain.repository.CoinRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repositoryInterface: CoinRepositoryInterface) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repositoryInterface.getCoins().map{it.toCoin()}
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Please check your connection!"))
        }
    }
}