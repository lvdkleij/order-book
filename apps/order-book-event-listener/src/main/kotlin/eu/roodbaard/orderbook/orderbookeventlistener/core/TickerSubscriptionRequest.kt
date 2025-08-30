package eu.roodbaard.orderbook.orderbookeventlistener.core

import kotlin.random.Random
import kotlin.random.nextInt

class TickerSubscriptionRequest(
    val currencyPairs: List<String>,
    val snapshot: Boolean = true,
    val eventTrigger: String = "trades",
    reqId: Int? = null,
) : SubscriptionRequest() {
    override val channel = "ticker"
    override val name = "Ticker (Level 1)"
    override fun toString(): String {
        return "{ channel: $channel, symbol: $currencyPairs, snapshot: $snapshot, event_trigger: $eventTrigger, reqId: $reqId }"
    }

    override val reqId = reqId ?: (1..Int.MAX_VALUE).random()

    override val paramMap = mapOf(
        "channel" to channel,
        "symbol" to currencyPairs,
        "snapshot" to snapshot,
        "event_trigger" to eventTrigger
    )
}