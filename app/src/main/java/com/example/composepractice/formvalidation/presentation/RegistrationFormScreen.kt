package com.example.composepractice.formvalidation.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composepractice.formvalidation.presentation.composables.AcceptTerms
import com.example.composepractice.formvalidation.presentation.composables.CustomTextField

@Composable
fun RegistrationForm(
    viewModel: FormValidationViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        val state = viewModel.state
        LaunchedEffect(key1 = true) {
            viewModel.channel.collect {
                when (it) {
                    FormValidationViewModel.ValidationUiEvent.Success -> {
                        Toast.makeText(
                            context,
                            "Success",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.email,
            error = state.emailError,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            visualTransformation = VisualTransformation.None,
            placeHolderText = "Email",
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.password,
            error = state.passwordError,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next,
            visualTransformation = PasswordVisualTransformation(),
            placeHolderText = "Password",
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.repeatedPassword,
            error = state.repeatedPasswordError,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            visualTransformation = PasswordVisualTransformation(),
            placeHolderText = "Confirm password",
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(it))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        AcceptTerms(
            modifier = Modifier.fillMaxWidth(),
            isAccepted = state.termsAccepted,
            error = state.termsError,
            onChange = {
                viewModel.onEvent(RegistrationFormEvent.AcceptedTerm(it))
            })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.onEvent(RegistrationFormEvent.Submit)
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Submit",
                textAlign = TextAlign.Center
            )
        }
    }
}