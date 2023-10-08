package com.mtgcards.extension

import com.mtgcards.controller.request.PostCardRequest
import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCardRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.enums.CardStatus
import com.mtgcards.model.Card
import com.mtgcards.model.Customer


fun PostCustomerRequest.toCustomer():Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id:Int):Customer {
    return Customer(id = id ,name = this.name, email = this.email)
}

fun PostCardRequest.toCard(customer:Customer):Card {
    return Card(name = this.name, price = this.price, customer = customer, status = CardStatus.MINT )
}

fun PutCardRequest.toCard(previousCard:Card):Card {
    return Card(
        id = previousCard.id,
        name = this.name ?: previousCard.name,
        price = this.price ?: previousCard.price,
        status = previousCard.status,
        customer = previousCard.customer

    )
}