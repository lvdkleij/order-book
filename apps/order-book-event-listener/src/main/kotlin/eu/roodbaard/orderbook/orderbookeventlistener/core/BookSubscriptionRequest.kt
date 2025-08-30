package eu.roodbaard.orderbook.orderbookeventlistener.core

class BookSubscriptionRequest(
    val currencyPairs: List<String>,
    val snapshot: Boolean = true,
    val depth: Int = 10,
    reqId: Int? = null,
) : SubscriptionRequest() {
    override val channel = "book"
    override val name = "Book (Level 2)"
    override val paramMap = mapOf(
        "channel" to channel,
        "symbol" to currencyPairs,
        "snapshot" to snapshot,
        "depth" to depth
    )
    override val reqId = reqId ?: (1..Int.MAX_VALUE).random()
    override fun toString(): String {
        return "{ channel: $channel, symbol: $currencyPairs, snapshot: $snapshot, depth: $depth, reqId: $reqId }"
    }
}