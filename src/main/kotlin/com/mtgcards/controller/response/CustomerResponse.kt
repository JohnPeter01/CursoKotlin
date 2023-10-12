package com.mtgcards.controller.response

import com.mtgcards.enums.CustomerStatus

data class CustomerResponse (
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus,

)
