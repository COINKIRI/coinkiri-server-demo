package coinkiri.api.controller.coin.dto.response



data class CoinPriceDto(
    val market: String,
//    val candleDateTimeUtc: String,
    val candleDateTimeKst: String,
//    val openingPrice: Double,
//    val highPrice: Double,
//    val lowPrice: Double,
    val tradePrice: Double,
//    val timestamp: Long,
//    val candleAccTradePrice: Double,
//    val candleAccTradeVolume: Double,
//    val prevClosingPrice: Double,
//    val changePrice: Double,
//    val changeRate: Double
)