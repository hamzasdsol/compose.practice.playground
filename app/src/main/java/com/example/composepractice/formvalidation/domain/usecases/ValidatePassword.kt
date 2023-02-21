package com.example.composepractice.formvalidation.domain.usecases

import javax.inject.Inject

class ValidatePassword @Inject constructor() {
    fun execute(password: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                message = "Password cannot be empty"
            )
        }
        if (password.length < PASSWORD_LENGTH) {
            return ValidationResult(
                successful = false,
                message = "Password should contain at least 8 characters"
            )
        }

        val containLettersAndDigits = password.any { it.isDigit() } && password.any { it.isLetter() }
        if (!containLettersAndDigits) {
            return ValidationResult(
                successful = false,
                message = "Password must contain one digit or letter"
            )
        }

        return ValidationResult(successful = true)
    }

    companion object {
        private const val PASSWORD_LENGTH = 8
    }
}