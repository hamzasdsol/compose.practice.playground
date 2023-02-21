package com.example.composepractice.formvalidation.domain.usecases

data class ValidationResult(
    val successful: Boolean,
    val message: String? = null
)
