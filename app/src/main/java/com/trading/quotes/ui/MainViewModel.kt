package com.trading.quotes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trading.quotes.domain.ObserveTradingQuotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class MainViewModel(
    private val observeTradingQuotesUseCase: ObserveTradingQuotesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(TradingQuotesState())
    val uiState: StateFlow<TradingQuotesState> = _uiState.asStateFlow()

    init {
        observeTradingQuotesUseCase.invoke()
            .onEach {  }
            .catch {  }
            .launchIn(viewModelScope)
    }
}
