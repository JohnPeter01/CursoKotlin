package com.mtgcards.extension

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.model.Customer


fun PostCustomerRequest.toCustomerModel():Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id:String):Customer {
    return Customer(id = id ,name = this.name, email = this.email)
}