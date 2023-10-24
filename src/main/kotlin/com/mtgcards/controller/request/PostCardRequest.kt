package com.mtgcards.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal

data class PostCardRequest(
    @field:NotEmpty
    var name: String,
    @field:NotEmpty
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Int
) {

}
