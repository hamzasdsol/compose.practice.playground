package com.example.composepractice.formvalidation.domain.usecases

import javax.inject.Inject

class ValidateTermsAccepted @Inject constructor(){
    fun execute(accepted: Boolean): ValidationResult {
        if (!accepted) {
            return ValidationResult(
                successful = false,
                message = "Please accept the terms"
            )
        }

        return ValidationResult(successful = true)
    }
}