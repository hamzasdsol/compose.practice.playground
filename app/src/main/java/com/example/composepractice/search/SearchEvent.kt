package com.example.composepractice.search

sealed class SearchEvent {
    data class TextChange(val newText: String) : SearchEvent()
    object AddClick: SearchEvent()
}