package com.example.composepractice.formvalidation.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AcceptTerms(
    modifier: Modifier = Modifier,
    isAccepted: Boolean = false,
    error: String? = null,
    onChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isAccepted,
            onCheckedChange = {
                onChange(it)
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Accept terms")
        Spacer(modifier = Modifier.width(16.dp))
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colors.error
            )
        }
    }
}