package com.example.composepractice.search

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {
    private var _name = mutableStateOf("")
    val name: State<String> = _name

    var names by mutableStateOf(listOf<String>())

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.TextChange -> {
                _name.value = event.newText
            }
            SearchEvent.AddClick -> {
                names = names + name.value
                _name.value = ""
            }
        }
    }
}