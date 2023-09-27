package com.mtgcards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MtgCardsApplication

fun main(args: Array<String>) {
	runApplication<MtgCardsApplication>(*args)
}
