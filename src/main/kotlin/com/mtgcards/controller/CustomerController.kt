package com.mtgcards.controller

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    val costumers = mutableListOf<Customer>()

    @GetMapping
    fun getAllCustomers(): MutableList<Customer> {
        return costumers
    }

    @GetMapping("/{id}")
    fun getOneCustomer(@PathVariable id: String): Customer {
        return costumers.filter { it.id == id }.first()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody request: PostCustomerRequest) {
        val id = if(costumers.isEmpty())
             "1"
        else {
            costumers.last().id.toInt() + 1
        }.toString()
        val costumer = Customer(id,request.name,request.email)
        costumers.add(costumer)
    }

}