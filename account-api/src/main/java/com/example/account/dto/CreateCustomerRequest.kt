package com.example.account.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class CreateCustomerRequest(
//    @field:NotBlank(message = "CustomerId must not be empty")
    val id: String,
    @field:NotBlank( message = "Name must not be empty")
    val name: String,
    @field:NotBlank( message = "Surname must not be empty")
    val surname: String
)
