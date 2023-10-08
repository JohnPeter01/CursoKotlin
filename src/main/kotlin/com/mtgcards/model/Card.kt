package com.mtgcards.model

import com.mtgcards.enums.CardStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "card")
data class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var price: BigDecimal,
    @Column
    @Enumerated(EnumType.STRING)
    var status: CardStatus,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer?
    )