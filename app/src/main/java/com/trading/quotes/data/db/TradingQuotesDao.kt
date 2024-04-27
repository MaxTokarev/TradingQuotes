package com.trading.quotes.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TradingQuotesDao {

    @Insert
    suspend fun insert(quotes: List<TradingQuotesDb>)

    @Query("SELECT * FROM ${TradingQuotesDb.TableName}")
    fun observe(): Flow<List<TradingQuotesDb>>
}
