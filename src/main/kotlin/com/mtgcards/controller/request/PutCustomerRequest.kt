package com.mtgcards.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PutCustomerRequest(
    @field:NotEmpty(message = "Campo nome não deve estar vazio.")
    var name: String,
    @field:Email(message = "Favor validar o valor do email")
    var email: String,
)