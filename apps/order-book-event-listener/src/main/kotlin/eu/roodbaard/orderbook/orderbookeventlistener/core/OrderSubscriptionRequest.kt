package eu.roodbaard.orderbook.orderbookeventlistener.core

class OrderSubscriptionRequest(
    val currencyPairs: List<String>,
    val snapshot: Boolean = true,
    token: String,
     reqId: Int? = null,
) : SubscriptionRequest() {
    override val channel = "level3"
    override val name = "Order (Level 3)"
    override val paramMap = mapOf(
        "channel" to channel,
        "symbol" to currencyPairs,
        "snapshot" to snapshot,
        "token" to token
    )
    override val reqId = reqId ?: (1..Int.MAX_VALUE).random()
    override fun toString(): String {
        return "{ channel: $channel, symbol: $currencyPairs, snapshot: $snapshot, reqId: $reqId }"
    }

}