package com.example.notes.domain.data

data class ValidationResult(
    val successful: Boolean,
    val message: String? = null
)