package com.trading.quotes.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.trading.quotes.data.db.TradingQuotesDb.Companion.TableName

@Entity(tableName = TableName)
class TradingQuotesDb(
    @PrimaryKey
    val id: String,
) {

    companion object {
        const val TableName = "TradingQuote"
    }
}
