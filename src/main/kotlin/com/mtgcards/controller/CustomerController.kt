package com.mtgcards.controller

import com.mtgcards.model.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getAllCustomers(): Customer {
        return Customer("1","João","joao.pedro.fehc@gmail.com");
    }

}