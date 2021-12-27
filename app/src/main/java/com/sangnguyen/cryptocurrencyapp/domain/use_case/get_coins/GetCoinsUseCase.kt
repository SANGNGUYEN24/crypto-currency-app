package com.sangnguyen.cryptocurrencyapp.domain.use_case.get_coins

import com.sangnguyen.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){

}