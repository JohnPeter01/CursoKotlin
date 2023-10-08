package com.mtgcards.repository

import com.mtgcards.enums.CardStatus
import com.mtgcards.model.Card
import com.mtgcards.model.Customer
import org.springframework.data.repository.CrudRepository

interface CardRepository : CrudRepository<Card,Int>{
     fun findByNameContaining(name: String): List<Card>
     fun findByStatus(name: CardStatus): List<Card>
     fun findByCustomer(customer: Customer):List<Card>
}