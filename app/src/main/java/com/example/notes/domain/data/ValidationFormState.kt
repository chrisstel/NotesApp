package com.example.notes.domain.data

data class ValidationFormState(
    val nicknameError: String? = null,
    val emailAddressError: String? = null,
    val passwordError: String? = null,
)
