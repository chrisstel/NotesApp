package com.example.notes.domain.usecase

import com.example.notes.domain.data.ValidationResult

class ValidatePasswordUseCase {

    fun validate(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                message = "The password must consist of at least 8 characters"
            )
        }

        val containsDigitAndLetter = password.any { it.isDigit() } && password.any { it.isLetter() }

        if (!containsDigitAndLetter) {
            return ValidationResult(
                successful = false,
                message = "The password must contain at least 1 letter and digit"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}