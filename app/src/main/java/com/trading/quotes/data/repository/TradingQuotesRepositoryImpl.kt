package com.trading.quotes.data.repository

import com.trading.quotes.domain.entity.TradingQuotes
import com.trading.quotes.domain.repository.TradingQuotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TradingQuotesRepositoryImpl : TradingQuotesRepository {

    override fun observeQuotes(): Flow<TradingQuotes> {
        return flowOf(
            TradingQuotes()
        )
    }
}
