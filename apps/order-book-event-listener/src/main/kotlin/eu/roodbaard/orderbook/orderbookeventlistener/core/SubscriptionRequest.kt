package eu.roodbaard.orderbook.orderbookeventlistener.core

import com.fasterxml.jackson.databind.ObjectMapper

abstract class SubscriptionRequest {
    protected val objectMapper: ObjectMapper = ObjectMapper()
    abstract val channel: String
    abstract val paramMap: Map<String, Any>
    abstract val reqId: Int?
    abstract val name: String

    val message: String get() {
        val messageBody = mutableMapOf(
            "method" to "subscribe",
            "params" to paramMap,
        )

        reqId?.let { messageBody["req_id"] = it}

        return objectMapper.writeValueAsString(messageBody)
    }

    abstract override fun toString(): String
}