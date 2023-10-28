package com.mtgcards.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PostCardRequest(
    @field:NotEmpty(message = "Campo nome não deve estar vazio.")
    var name: String,
    @field:NotEmpty(message = "Campo preço não deve estar vazio.")
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Int
) {

}
