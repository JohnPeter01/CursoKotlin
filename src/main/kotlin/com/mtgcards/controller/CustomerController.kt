package com.mtgcards.controller

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.controller.response.CustomerResponse
import com.mtgcards.extension.toCustomer
import com.mtgcards.extension.toResponse
import com.mtgcards.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
    fun getAllCustomers(@RequestParam name: String?, @PageableDefault(page = 0,size = 10) pageable: Pageable): Page<CustomerResponse> {
        return customerService.getAll(name, pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getOneCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.getById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody request: PostCustomerRequest) {
        customerService.create(request.toCustomer())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody request: PutCustomerRequest) {
        val previousCustomer = customerService.getById(id)
        customerService.update(request.toCustomer(previousCustomer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.delete(id)
    }

}