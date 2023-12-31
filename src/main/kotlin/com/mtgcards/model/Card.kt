package com.mtgcards.model

import com.mtgcards.enums.CardConservaiton
import com.mtgcards.enums.CardStatus
import com.mtgcards.enums.Errors
import com.mtgcards.exception.BadRequestException
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
    var conservation: CardConservaiton,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer?
    ){

    constructor(id: Int? = null, name: String, price: BigDecimal,conservation: CardConservaiton ,customer: Customer?,
    status: CardStatus?): this(id,name,price,conservation,customer){
        this.status = status
    }
    @Column
    @Enumerated(EnumType.STRING)
    var status: CardStatus? = null
        set(value) {
            if(CardStatus.EMREVISAO == field || CardStatus.INATIVO == field)
                throw BadRequestException(Errors.ML102.message.format(field),Errors.ML201.code)
            field = value
        }
}