package com.example.notes.domain.usecase

import com.example.notes.domain.data.ValidationResult

class ValidateNicknameUseCase {

    fun validate(nickname: String): ValidationResult {
        if (nickname.isBlank()) {
            return ValidationResult(
                successful = false,
                message = "Nickname can't be blank"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}