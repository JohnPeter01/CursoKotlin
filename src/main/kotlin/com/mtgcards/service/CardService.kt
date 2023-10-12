package com.mtgcards.service

import com.mtgcards.enums.CardStatus
import com.mtgcards.model.Card
import com.mtgcards.model.Customer
import com.mtgcards.repository.CardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CardService(
    val repository: CardRepository
) {
    fun getAll(pageable: Pageable): Page<Card> {
        return repository.findAll(pageable)
    }

    fun getById(id: Int): Card {
        return repository.findById(id).orElseThrow()
    }

    fun getByStatus(pageable: Pageable): Page<Card> {
        return repository.findByStatus(CardStatus.ATIVO, pageable)
    }

    fun create(cardData: Card) {
        repository.save(cardData)
    }

    fun update(card: Card) {
        if (!repository.existsById(card.id!!)){
            throw Exception("Card não existente para atualizado.")
        }
        repository.save(card)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)){
            throw Exception("Card não existente para atualizado.")
        }
        val card = repository.findById(id).orElseThrow()
        card.status = CardStatus.INATIVO
        repository.save(card)
    }

    fun deleteByCustomer(customer: Customer) {
        val cards = repository.findByCustomer(customer)
        for (card in cards){
            card.status = CardStatus.INATIVO
            repository.save(card)
        }
    }

}
