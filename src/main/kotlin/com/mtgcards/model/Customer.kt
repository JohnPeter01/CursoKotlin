package com.mtgcards.model

import com.mtgcards.enums.CustomerStatus
import jakarta.persistence.*

@Entity(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var email: String,
    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,
    )