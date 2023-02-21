package com.example.composepractice.formvalidation.domain.usecases

import android.util.Patterns
import javax.inject.Inject

class ValidateEmail @Inject constructor() {
    fun execute(email: String): ValidationResult {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                message = "Email is invalid"
            )
        }

        return ValidationResult(successful = true)
    }
}