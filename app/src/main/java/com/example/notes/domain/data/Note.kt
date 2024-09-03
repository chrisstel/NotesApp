package com.example.notes.domain.data

import java.io.Serializable

data class Note(
    val id: Int = 0,
    val date: String,
    val text: String
) : Serializable