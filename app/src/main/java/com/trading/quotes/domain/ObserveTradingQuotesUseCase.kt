package com.trading.quotes.domain

import com.trading.quotes.domain.entity.TradingQuotes
import com.trading.quotes.domain.repository.TradingQuotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

internal interface ObserveTradingQuotesUseCase {

    operator fun invoke(): Flow<TradingQuotes>
}

internal class ObserveTradingQuotesUseCaseImpl(
    private val tradingQuotesRepository: TradingQuotesRepository,
): ObserveTradingQuotesUseCase {

    override fun invoke(): Flow<TradingQuotes> {
        return tradingQuotesRepository.observeQuotes()
            .filter { true } // todo add filtering
    }
}
