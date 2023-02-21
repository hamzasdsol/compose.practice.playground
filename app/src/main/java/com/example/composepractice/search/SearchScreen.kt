package com.example.composepractice.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val textState = viewModel.name
    var names = viewModel.names
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AddNewItem(
            value = textState.value,
            onChange = { viewModel.onEvent(SearchEvent.TextChange(it)) },
            onAddClick = { if (textState.value.isNotBlank()) viewModel.onEvent(SearchEvent.AddClick) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(names) { name ->
                Text(text = name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
            }
        }
    }
}

@Composable
fun AddNewItem(
    value: String = "",
    onChange: (String) -> Unit,
    onAddClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = value,
            onValueChange = {
                onChange(it)
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onAddClick
        ) {
            Text(text = "Add")
        }
    }
}