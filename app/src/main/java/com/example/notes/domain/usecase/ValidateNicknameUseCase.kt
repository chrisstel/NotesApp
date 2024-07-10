package com.example.notes.domain.usecase

import com.example.notes.domain.data.ValidationResult

class ValidateNicknameUseCase {

    operator fun invoke(nickname: String): ValidationResult = when {
        blank(nickname) -> {
            ValidationResult.Error(
                message = "The nickname can't be empty"
            )
        }

        else -> ValidationResult.Success
    }

    private fun blank(nickname: String): Boolean = nickname.isBlank()
}