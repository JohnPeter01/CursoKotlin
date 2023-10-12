package com.mtgcards.service

import com.mtgcards.enums.CustomerStatus
import com.mtgcards.model.Customer
import com.mtgcards.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val repository: CustomerRepository,
    val cardService: CardService
) {
    fun getAll(name: String?,pageable: Pageable): Page<Customer> {
        name?.let {
            return repository.findByNameContaining(it, pageable)
        }
        return repository.findAll(pageable)
    }

    fun getById(id: Int): Customer {
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
        val customer = getById(id)
        customer.status = CustomerStatus.INATIVO
        cardService.deleteByCustomer(customer)
        repository.save(customer)
    }

}