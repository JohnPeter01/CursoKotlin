package com.mtgcards.repository

import com.mtgcards.model.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer,Int>{
     fun findByNameContaining(name: String, pageable: Pageable): Page<Customer>
     fun existsByEmail(email: String): Boolean
}