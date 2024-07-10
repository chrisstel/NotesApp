package com.example.notes.domain.usecase

import com.example.notes.domain.data.ValidationResult

class ValidatePasswordUseCase {

    companion object {
        private const val MINIMUM_LENGTH = 8
    }

    operator fun invoke(password: String): ValidationResult = when {
        lessThanMinimum(password) -> {
            ValidationResult.Error(
                message = "The password must consist of at least 8 characters"
            )
        }

        noDigit(password) && noLetter(password) -> {
            ValidationResult.Error(
                message = "The password must contain at least 1 letter and digit"
            )
        }

        else -> ValidationResult.Success
    }

    private fun lessThanMinimum(password: String): Boolean = password.length < MINIMUM_LENGTH
    private fun noLetter(password: String): Boolean = !password.any { it.isLetter() }
    private fun noDigit(password: String): Boolean = !password.any { it.isDigit()}
}