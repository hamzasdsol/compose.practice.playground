package com.example.composepractice.formvalidation.presentation.composables

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    error: String?,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Default,
    visualTransformation: VisualTransformation,
    placeHolderText: String,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        isError = error != null,
        placeholder = {
            Text(text = placeHolderText)
        },
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        visualTransformation = visualTransformation,
        singleLine = singleLine,
    )
    if (error != null) {
        Text(
            text = error,
            color = MaterialTheme.colors.error
        )
    }
}