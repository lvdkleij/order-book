package eu.roodbaard.orderbook.orderbookeventlistener.implementation

import com.fasterxml.jackson.core.JsonProcessingException
import eu.roodbaard.orderbook.orderbookeventlistener.core.BookSubscriptionRequest
import eu.roodbaard.orderbook.orderbookeventlistener.core.SubscriptionRequest
import eu.roodbaard.orderbook.orderbookeventlistener.core.TickerSubscriptionRequest
import org.springframework.stereotype.Service
import org.springframework.web.socket.client.WebSocketClient
import org.springframework.web.socket.client.standard.StandardWebSocketClient

@Service
class RawWebSocketClient {
    private val publicUrl = "wss://ws.kraken.com/v2"
    private val client: WebSocketClient = StandardWebSocketClient()

    private val subscriptionRequests: List<SubscriptionRequest> = listOf(
//        TickerSubscriptionRequest(currencyPairs = listOf("BTC/USD")),
        BookSubscriptionRequest(currencyPairs = listOf("BTC/USD","BTC/EUR"))
    )

    @Throws(JsonProcessingException::class)
    fun connect() {
        val webSocketHandler = KrakenPublicWebSocketHandler(subscriptionRequests)
        client.execute(webSocketHandler, publicUrl)
    }
}