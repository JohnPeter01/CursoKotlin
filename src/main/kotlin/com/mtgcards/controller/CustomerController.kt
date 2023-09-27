package com.mtgcards.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @GetMapping
    fun getCustomer(): String {
        return "Ainda não temos clientes senhor(a)"
    }
}