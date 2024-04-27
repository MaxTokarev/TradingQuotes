package com.trading.quotes.domain.repository

import com.trading.quotes.domain.entity.TradingQuotes
import kotlinx.coroutines.flow.Flow

interface TradingQuotesRepository {

    fun insert(quotes: TradingQuotes)
    fun observeQuotes(): Flow<TradingQuotes>
}
