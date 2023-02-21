package com.example.composepractice.search

data class SearchViewModelState(
    val names: List<String> = emptyList(),
    val text: String = ""
)
