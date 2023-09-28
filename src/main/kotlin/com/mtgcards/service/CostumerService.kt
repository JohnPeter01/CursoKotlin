package com.mtgcards.service

import com.mtgcards.controller.request.PostCustomerRequest
import com.mtgcards.controller.request.PutCustomerRequest
import com.mtgcards.model.Customer
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CostumerService {
    val costumers = mutableListOf<Customer>()

    fun getAll(name: String?): List<Customer> {
        name?.let {
            return costumers.filter { it.name.contains(name, true) }
        }
        return costumers
    }

    fun search(id: String): Customer {
        return costumers.first { it.id == id }
    }

    fun create(costumerData: PostCustomerRequest) {
        val id = if(costumers.isEmpty())
            "1"
        else {
            costumers.last().id.toInt() + 1
        }.toString()
        val newCostumer = Customer(id,costumerData.name,costumerData.email)
        costumers.add(newCostumer)
    }

    fun update( id: String, request: PutCustomerRequest) {
        costumers.first { it.id == id }.let {
            it.name = request.name
            it.email = request.email
        }
    }

    fun delete(id: String) {
        costumers.removeIf { it.id == id }
    }

}