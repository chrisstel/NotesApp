package com.example.notes.domain.usecase

import android.util.Patterns
import com.example.notes.domain.data.ValidationResult

class ValidateEmailAddressUseCase {

    operator fun invoke(email: String): ValidationResult = when {
        blank(email) -> {
            ValidationResult.Error(
                message = "The email address can't be blank"
            )
        }

        noMatch(email) -> {
            ValidationResult.Error(
                message = "This email is not valid"
            )
        }

        else -> ValidationResult.Success
    }

    private fun blank(email: String): Boolean = email.isBlank()
    private fun noMatch(email: String): Boolean = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
}