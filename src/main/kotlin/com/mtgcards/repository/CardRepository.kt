package com.mtgcards.repository

import com.mtgcards.enums.CardStatus
import com.mtgcards.model.Card
import com.mtgcards.model.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<Card,Int>{
     fun findByStatus(name: CardStatus, pageable: Pageable): Page<Card>
     fun findByCustomer(customer: Customer):List<Card>

}