package com.example.notes.domain.data

data class ValidationFormState(
    var nicknameError: String? = null,
    var emailAddressError: String? = null,
    var passwordError: String? = null,
)
