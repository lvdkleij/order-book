package eu.roodbaard.orderbook.orderbookeventlistener.implementation

import eu.roodbaard.orderbook.orderbookeventlistener.core.SubscriptionRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession

class KrakenPublicWebSocketHandler(private val subscriptionRequests: List<SubscriptionRequest>) :
    WebSocketHandler {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun afterConnectionEstablished(session: WebSocketSession) {
        subscriptionRequests.forEach { request ->
            logger.info("🔗✅ Connected to Kraken ${request.name} WebSocket with params: $request")
            session.sendMessage(TextMessage(request.message))
        }
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        val payload: String = message.getPayload().toString()
        logger.info(payload)
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        logger.error(
            "❌ Transport error in session {} with URI {}: {}",
            session.id,
            exception.message,
            exception
        )
    }

    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        logger.info("🔗❌ Connection closed to Kraken Book (Level 2) WebSocket with status $closeStatus")
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}