package com.mtgcards.controller.request

import com.mtgcards.validation.EmailAvaliable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Campo nome não deve estar vazio.")
    var name: String,
    @field:Email(message = "Favor validar o valor do email")
    @EmailAvaliable
    var email: String,
)