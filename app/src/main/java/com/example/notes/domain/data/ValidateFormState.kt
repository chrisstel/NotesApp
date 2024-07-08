package com.example.notes.domain.data

data class ValidateFormState(
    val fullName: String = "",
    val fullNameError: String? = null,
    val emailAddress: String = "",
    val emailAddressError: String? = null,
    val password: String = "",
    val passwordError: String? = null
)
