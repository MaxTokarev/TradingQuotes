package com.trading.quotes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.trading.quotes.data.repository.TradingQuotesRepositoryImpl
import com.trading.quotes.domain.ObserveTradingQuotesUseCaseImpl
import com.trading.quotes.ui.screen.TradingQuotesScreen
import com.trading.quotes.ui.theme.TradingQuotesTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel> {
        viewModelFactory {
            initializer {
                MainViewModel(
                    ObserveTradingQuotesUseCaseImpl(
                        TradingQuotesRepositoryImpl()
                    )
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TradingQuotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val uiState by viewModel.uiState.collectAsState()
                    TradingQuotesScreen(
                        state = uiState,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
