package com.mtgcards.exception

data class BadRequestException(override val message: String, val errorCode: String): Exception()  {
}