package com.trading.quotes.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive

interface TradingQuotesSocketService {

    fun connectTo(): Flow<String>
}

private const val SERVER = "wss.tradernet.com"
private const val SUBSCRIPTION = "realtimeQuotes"

class TradingQuotesSocketServiceImpl : TradingQuotesSocketService {

    override fun connectTo(): Flow<String> {
        val client = HttpClient {
            install(WebSockets)
        }
        return flow {
            client.webSocket(
                method = HttpMethod.Get,
                host = SERVER,
                path = "/$SUBSCRIPTION"
            ) {
                while (isActive) {
                    val othersMessage = incoming.receive() as? Frame.Text ?: continue
                    println(othersMessage.readText())
                    val myMessage = readlnOrNull()
                    if (myMessage != null) {
                        emit(myMessage)
                    }
                }
            }
            client.close()
            println("Connection closed. Goodbye!")
        }
    }
}
