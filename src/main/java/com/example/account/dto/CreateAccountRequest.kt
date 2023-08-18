package com.example.account.dto

import java.math.BigDecimal
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class CreateAccountRequest(
    @field:NotBlank(message = "CustomerId must not be empty")
    val customerId: String,
    @field:Min(0, message = "Initial Credit value must not be negative value")
    val initialCredit: BigDecimal
)
