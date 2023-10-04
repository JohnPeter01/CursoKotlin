package com.mtgcards.service

import com.mtgcards.model.Customer
import com.mtgcards.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val repository: CustomerRepository
) {
    fun getAll(name: String?): List<Customer> {
        name?.let {
            return repository.findByNameContaining(it)
        }
        return repository.findAll().toList()
    }

    fun search(id: Int): Customer {
        return repository.findById(id).orElseThrow()
    }

    fun create(customerData: Customer) {
        repository.save(customerData)
    }

    fun update(customer: Customer) {
        if (!repository.existsById(customer.id!!)){
            throw Exception("Cliente não existente para atualizado.")
        }
        repository.save(customer)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)){
            throw Exception("Cliente não existente para atualizado.")
        }
        repository.deleteById(id)
    }

}