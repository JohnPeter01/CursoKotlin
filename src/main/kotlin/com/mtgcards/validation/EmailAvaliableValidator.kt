package com.mtgcards.validation

import com.mtgcards.service.CustomerService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class EmailAvaliableValidator(var costumerService: CustomerService): ConstraintValidator<EmailAvaliable,String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value.isNullOrBlank()){
            return false
        }
        return costumerService.emailAvaliable(value)
    }
}