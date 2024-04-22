package com.trading.quotes.ui

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal class TradingQuotesState(
    val quotes: ImmutableList<TradingQuoteState> = emptyList(),
)

@Immutable
internal class TradingQuoteState(
    val ticker: String,
    val name: String,
    val logo: String,
    val lastPrice: String,
    val lastTradingPlatform: String,
    val change: String,
    val changeColor: Color,
)
