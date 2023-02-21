package com.example.composepractice.formvalidation.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepractice.formvalidation.domain.usecases.ValidateEmail
import com.example.composepractice.formvalidation.domain.usecases.ValidatePassword
import com.example.composepractice.formvalidation.domain.usecases.ValidateRepeatedPassword
import com.example.composepractice.formvalidation.domain.usecases.ValidateTermsAccepted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormValidationViewModel @Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateRepeatedPassword: ValidateRepeatedPassword,
    private val validateTerms: ValidateTermsAccepted,

): ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private var _channel = Channel<ValidationUiEvent>()
    val channel = _channel.receiveAsFlow()


    fun onEvent(event: RegistrationFormEvent) {
        when(event) {
            is RegistrationFormEvent.AcceptedTerm -> {
                state = state.copy(
                    termsAccepted = event.isAccepted
                )
            }
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(
                    email = event.newEmail
                )
            }
            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(
                    password = event.newPassword
                )
            }
            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(
                    repeatedPassword = event.newPassword
                )
            }
            RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.execute(state.password, state.repeatedPassword)
        val termAcceptedResult = validateTerms.execute(state.termsAccepted)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termAcceptedResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.message,
                passwordError = passwordResult.message,
                repeatedPasswordError = repeatedPasswordResult.message,
                termsError = termAcceptedResult.message
            )
            return
        }

        viewModelScope.launch {
            _channel.send(ValidationUiEvent.Success)
            state = RegistrationFormState()
        }
    }

    sealed class ValidationUiEvent {
        object Success: ValidationUiEvent()
    }
}