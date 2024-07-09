package com.example.notes.ui.create_account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.domain.data.ValidationFormState
import com.example.notes.domain.data.ValidationResult
import com.example.notes.domain.usecase.ValidateEmailAddressUseCase
import com.example.notes.domain.usecase.ValidateNicknameUseCase
import com.example.notes.domain.usecase.ValidatePasswordUseCase

class CreateAccountViewModel(
    private val validateNicknameUseCase: ValidateNicknameUseCase,
    private val validateEmailAddressUseCase: ValidateEmailAddressUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {

    private val _signUpResult = MutableLiveData<ValidationFormState>()
    val signUpResult: LiveData<ValidationFormState> = _signUpResult

    fun signUp(nickname: String, emailAddress: String, password: String) {
        val isNicknameValid = validateNicknameUseCase.validate(nickname)
        val isEmailAddressValid = validateEmailAddressUseCase.validate(emailAddress)
        val isPasswordValid = validatePasswordUseCase.validate(password)

        val hasError = listOf(isNicknameValid, isEmailAddressValid, isPasswordValid).any { !it.successful }

       _signUpResult.value = ValidationFormState(
           nicknameError = isNicknameValid.message,
           emailAddressError = isNicknameValid.message,
           passwordError = isPasswordValid.message,
       )
    }
}