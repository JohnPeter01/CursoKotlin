package com.mtgcards.controller

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.extension.toCustomerModel
import com.mtgcards.model.Customer
import com.mtgcards.service.CustomerService
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
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<Customer> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getOneCustomer(@PathVariable id: Int): Customer {
        return customerService.search(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody request: PostCustomerRequest) {
        customerService.create(request.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody request: PutCustomerRequest) {
        customerService.update(request.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.delete(id)
    }

}