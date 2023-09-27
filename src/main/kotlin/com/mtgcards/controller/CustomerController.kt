package com.mtgcards.controller

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getAllCustomers(): Customer {
        return Customer("1","João","joao.pedro.fehc@gmail.com");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest): Customer {
        println(customer)
        return Customer("2",customer.name,customer.email)
    }

}