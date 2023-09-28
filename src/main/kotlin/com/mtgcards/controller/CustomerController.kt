package com.mtgcards.controller

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    val costumers = mutableListOf<Customer>()

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<Customer> {
        name?.let {
            return costumers.filter { it.name.contains(name, true) }
        }
        return costumers
    }

    @GetMapping("/{id}")
    fun getOneCustomer(@PathVariable id: String): Customer {
        return costumers.first { it.id == id }
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody request: PutCustomerRequest) {
        costumers.first { it.id == id }.let {
            it.name = request.name
            it.email = request.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        costumers.removeIf { it.id == id }
    }

}