package com.trading.quotes.ui

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
internal data class TradingQuotesState(
    val quotes: ImmutableList<TradingQuoteState> = persistentListOf(
        TradingQuoteState(
            "FEES",
            "МСХ | ФСК ЕЭС ао",
            "",
            "0.210 76(+0.006 88)",
            "МСХ | ФСК ЕЭС ао",
            "+3.37%",
            Color.Green
        )
    ),
)

@Immutable
internal data class TradingQuoteState(
    val ticker: String,
    val name: String,
    val logo: String,
    val lastPrice: String,
    val lastTradingPlatform: String,
    val change: String,
    val changeColor: Color,
)
