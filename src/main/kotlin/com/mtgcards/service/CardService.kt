package com.mtgcards.service

import com.mtgcards.enums.CardStatus
import com.mtgcards.model.Card
import com.mtgcards.model.Customer
import com.mtgcards.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class CardService(
    val repository: CardRepository
) {
    fun getAll(name: String?): List<Card> {
        name?.let {
            return repository.findByNameContaining(it)
        }
        return repository.findAll().toList()
    }

    fun getById(id: Int): Card {
        return repository.findById(id).orElseThrow()
    }

    fun getByStatus(): List<Card> {
        return repository.findByStatus(CardStatus.MINT)
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
        repository.deleteById(id)
    }

    fun deleteByCustomer(customer: Customer) {
        val cards = repository.findByCustomer(customer)
        for (card in cards){
            repository.delete(card)
        }
    }

}
