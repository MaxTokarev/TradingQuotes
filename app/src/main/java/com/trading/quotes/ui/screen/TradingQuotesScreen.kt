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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
            TradingQuoteItem(state = quote, modifier = Modifier.padding(all = 8.dp))
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(Color.LightGray)
            )
        }
    }
}

@Composable
internal fun TradingQuoteItem(state: TradingQuoteState, modifier: Modifier = Modifier) {
    Row(modifier) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Row {
                AsyncImage(
                    model = state.logo,
                    contentDescription = null
                )
                Text(text = state.ticker, style = MaterialTheme.typography.titleLarge)
            }
            Text(
                text = state.lastTradingPlatform,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray,
            )
        }

        Column(Modifier, horizontalAlignment = Alignment.End) {
            Text(text = state.change, color = state.changeColor, style = MaterialTheme.typography.titleLarge)
            Text(text = state.lastPrice, style = MaterialTheme.typography.labelMedium)
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Gray),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp)
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

