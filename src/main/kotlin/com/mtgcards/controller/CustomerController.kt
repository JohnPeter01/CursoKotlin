package com.mtgcards.controller

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.extension.toCustomerModel
import com.mtgcards.model.Customer
import com.mtgcards.service.CostumerService
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
    val costumerService: CostumerService
) {
    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<Customer> {
        return costumerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getOneCustomer(@PathVariable id: String): Customer {
        return costumerService.search(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody request: PostCustomerRequest) {
        costumerService.create(request.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody request: PutCustomerRequest) {
        costumerService.update(request.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        costumerService.delete(id)
    }

}