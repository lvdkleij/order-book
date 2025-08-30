package eu.roodbaard.orderbook.orderbookeventlistener.implementation

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class WebSocketRunner(private val webSocketClient: RawWebSocketClient) : CommandLineRunner {
    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        webSocketClient.connect()

        synchronized(this) {
            (this as Object).wait() // Keeps the app running
        }
    }
}