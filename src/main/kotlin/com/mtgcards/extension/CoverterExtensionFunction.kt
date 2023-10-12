package com.mtgcards.extension

import com.mtgcards.controller.request.PostCardRequest
import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCardRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.controller.response.CardResponse
import com.mtgcards.controller.response.CustomerResponse
import com.mtgcards.enums.CardConservaiton
import com.mtgcards.enums.CardStatus
import com.mtgcards.enums.CustomerStatus
import com.mtgcards.model.Card
import com.mtgcards.model.Customer


fun PostCustomerRequest.toCustomer():Customer {
    return Customer(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomer(previousCustomer:Customer):Customer {
    return Customer(
        id = previousCustomer.id,
        name = this.name ?: previousCustomer.name,
        email = this.email ?: previousCustomer.email,
        status = CustomerStatus.ATIVO)
}

fun PostCardRequest.toCard(customer:Customer):Card {
    return Card(
        name = this.name,
        price = this.price,
        customer = customer,
        status = CardStatus.ATIVO,
        conservation = CardConservaiton.MINT)
}

fun PutCardRequest.toCard(previousCard:Card):Card {
    return Card(
        id = previousCard.id,
        name = this.name ?: previousCard.name,
        price = this.price ?: previousCard.price,
        status = previousCard.status,
        conservation = previousCard.conservation,
        customer = previousCard.customer

    )
}
fun Customer.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status,
    )
}

fun Card.toResponse(): CardResponse {
    return CardResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        conservation = this.conservation,
        status = this.status,
        customer = this.customer
    )
}