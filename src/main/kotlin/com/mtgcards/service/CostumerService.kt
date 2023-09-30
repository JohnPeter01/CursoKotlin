package com.mtgcards.service

import com.mtgcards.model.Customer
import org.springframework.stereotype.Service

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

    fun create(costumerData: Customer) {
        val id = if(costumers.isEmpty())
            "1"
        else {
            costumers.last().id!!.toInt() + 1
        }.toString()

        costumerData.id = id;
        val newCostumer = Customer(id,costumerData.name,costumerData.email)
        costumers.add(newCostumer)
    }

    fun update(customer: Customer) {
        costumers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        costumers.removeIf { it.id == id }
    }

}