package com.trading.quotes.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.trading.quotes.R
import com.trading.quotes.ui.TradingQuoteState
import com.trading.quotes.ui.TradingQuotesState

@Composable
internal fun TradingQuotesScreen(state: TradingQuotesState, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(state.quotes)
    }
}

@Composable
internal fun TradingQuoteItem(state: TradingQuoteState, modifier: Modifier = Modifier) {
    Row(modifier) {
        Column {
            Row {
                AsyncImage(model = state.logo, contentDescription = null)
                Text(text = state.ticker)
            }
            Text(text = state.lastTradingPlatform)
        }

        Column(Modifier.weight(1f)) {
            Text(text = state.change)
            Text(text = state.lastPrice)
        }
        Image(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
    }
}

@Preview
@Composable
private fun TradingQuoteItemPreview() {
    TradingQuoteItem(
        state = TradingQuoteState("asd", "asf", "asdf", "adsf", "asdf", "asd", Color.Green)
    )
}

