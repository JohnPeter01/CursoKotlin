package com.mtgcards.controller.response

import com.mtgcards.enums.CardConservaiton
import com.mtgcards.enums.CardStatus
import com.mtgcards.model.Customer
import java.math.BigDecimal

data class CardResponse (
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var conservation: CardConservaiton,
    var status: CardStatus? = null,
    var customer: Customer? =null
)
