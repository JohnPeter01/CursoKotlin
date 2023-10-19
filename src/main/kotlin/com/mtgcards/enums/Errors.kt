package com.mtgcards.enums

enum class Errors(val code: String,val message: String) {
    ML101("ML-101","Carta de id [%s] não existe."),
    ML102("ML-102","Carta com o Status de [%s] não pode ser alterada."),
    ML201("ML-201","Cliente de id [%s] não existe.")
}