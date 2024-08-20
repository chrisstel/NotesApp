package com.example.notes.domain.usecase

import com.example.notes.domain.data.ValidationResult

class ValidateNicknameUseCase {

    operator fun invoke(nickname: String): ValidationResult = when {
        blank(nickname) -> {
            ValidationResult.Error(
                message = "The nickname can't be empty"
            )
        }

        tooLong(nickname) -> {
            ValidationResult.Error(
                message = "The nickname must be shorter"
            )
        }

        else -> ValidationResult.Success
    }

    private fun blank(nickname: String): Boolean = nickname.isBlank()
    private fun tooLong(nickname: String): Boolean = nickname.length > 10
}