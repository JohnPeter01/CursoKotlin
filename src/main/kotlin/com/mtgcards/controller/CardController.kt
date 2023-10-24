package com.mtgcards.controller

import com.mtgcards.controller.request.PostCardRequest
import com.mtgcards.controller.request.PutCardRequest
import com.mtgcards.controller.response.CardResponse
import com.mtgcards.extension.toCard
import com.mtgcards.extension.toResponse
import com.mtgcards.service.CardService
import com.mtgcards.service.CustomerService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cards")
class CardController(
    val cardService: CardService,
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllCards(@PageableDefault(page = 0,size = 10) pageable:Pageable): Page<CardResponse> = cardService.getAll(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun getOneCardById(@PathVariable id: Int): CardResponse = cardService.getById(id).toResponse()


    @GetMapping("/ativos")
    fun getActiveCards(@PageableDefault(page = 0,size = 10) pageable:Pageable): Page<CardResponse> = cardService.getByStatus(pageable).map { it.toResponse() }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCard(@RequestBody @Valid request: PostCardRequest) {
        val customer= customerService.getById(request.customerId)
        cardService.create(request.toCard(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody request: PutCardRequest) {
        val cardSaved = cardService.getById(id)
        cardService.update(request.toCard(cardSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCard(@PathVariable id: Int) {
        cardService.delete(id)
    }

}