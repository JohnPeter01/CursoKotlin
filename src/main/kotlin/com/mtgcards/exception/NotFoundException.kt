package com.mtgcards.exception

data class NotFoundException(override val message: String, val errorCode: String): Exception()  {
}