package com.example.notes.domain.usecase

import android.util.Patterns
import com.example.notes.domain.data.ValidationResult

class ValidateEmailAddressUseCase {

    fun validate(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                message = "The email address can't be blank"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                message = "This email is not valid"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}