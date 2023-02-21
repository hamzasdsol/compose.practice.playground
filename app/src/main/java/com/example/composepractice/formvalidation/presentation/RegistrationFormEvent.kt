package com.example.composepractice.formvalidation.presentation

sealed class RegistrationFormEvent {
    object Submit: RegistrationFormEvent()
    data class EmailChanged(val newEmail: String): RegistrationFormEvent()
    data class PasswordChanged(val newPassword: String): RegistrationFormEvent()
    data class RepeatedPasswordChanged(val newPassword: String): RegistrationFormEvent()
    data class AcceptedTerm(val isAccepted: Boolean): RegistrationFormEvent()
}
