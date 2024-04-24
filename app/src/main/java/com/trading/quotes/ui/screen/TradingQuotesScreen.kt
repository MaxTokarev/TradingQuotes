package com.trading.quotes.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trading.quotes.R
import com.trading.quotes.ui.TradingQuoteState
import com.trading.quotes.ui.TradingQuotesState
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun TradingQuotesScreen(state: TradingQuotesState, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 8.dp),
    ) {
        items(items = state.quotes, key = { quote -> quote.ticker }) { quote ->
            TradingQuoteItem(state = quote)
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(Color.Gray)
            )
        }
    }
}

@Composable
internal fun TradingQuoteItem(state: TradingQuoteState, modifier: Modifier = Modifier) {
    Row(
        modifier
            .wrapContentSize()
            .padding(all = 16.dp)
    ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Row {
                AsyncImage(
                    onError = {},
                    model = state.logo,
                    contentDescription = null
                )
                Text(text = state.ticker, style = MaterialTheme.typography.titleLarge)
            }
            Text(
                text = state.lastTradingPlatform,
                style = MaterialTheme.typography.labelMedium,
                color = Color.LightGray,
            )
        }

        Column(Modifier, horizontalAlignment = Alignment.End) {
            Text(text = state.change, color = state.changeColor)
            Text(text = state.lastPrice, style = MaterialTheme.typography.labelSmall)
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun TradingQuoteItemPreview() {
    Box {
        TradingQuoteItem(
            state = TradingQuoteState(
                ticker = "asd",
                name = "asf",
                logo = "asdf",
                lastPrice = "adsf",
                lastTradingPlatform = "asdf",
                change = "asd",
                changeColor = Color.Green
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun TradingQuoteScreenPreview() {
    TradingQuotesScreen(
        state = TradingQuotesState(
            quotes = persistentListOf(
                TradingQuoteState(
                    "FEES",
                    "МСХ | ФСК ЕЭС ао",
                    "",
                    "0.210 76(+0.006 88)",
                    "МСХ | ФСК ЕЭС ао",
                    "+3.37%",
                    Color.Green
                ),
                TradingQuoteState(
                    "FEES2",
                    "МСХ | ФСК ЕЭС ао",
                    "",
                    "0.210 76(+0.006 88)",
                    "МСХ | ФСК ЕЭС ао",
                    "+3.37%",
                    Color.Green
                )
            )
        )
    )
}

