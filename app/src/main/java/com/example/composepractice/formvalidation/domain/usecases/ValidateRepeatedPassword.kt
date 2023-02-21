package com.example.composepractice.formvalidation.domain.usecases

import javax.inject.Inject

class ValidateRepeatedPassword @Inject constructor(){
    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                message = "Passwords don't match"
            )
        }

        return ValidationResult(successful = true)
    }
}