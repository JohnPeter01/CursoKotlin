package com.mtgcards.controller.request

import java.math.BigDecimal

data class PutCardRequest(
    var name: String?,
    var price: BigDecimal?
)