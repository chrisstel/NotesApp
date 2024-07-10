package com.example.notes.ui.create_account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.data.ValidationFormState
import com.example.notes.domain.data.ValidationResult
import com.example.notes.domain.usecase.ValidateEmailAddressUseCase
import com.example.notes.domain.usecase.ValidateNicknameUseCase
import com.example.notes.domain.usecase.ValidatePasswordUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CreateAccountViewModel(
    private val validateNicknameUseCase: ValidateNicknameUseCase,
    private val validateEmailAddressUseCase: ValidateEmailAddressUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {

    private val _validationState = MutableLiveData(ValidationFormState())
    val validationState: LiveData<ValidationFormState> = _validationState

    private val _registrationResult = Channel<ValidationResult>()
    val registrationResult: Flow<ValidationResult> = _registrationResult.receiveAsFlow()

    fun signUp(nickname: String, emailAddress: String, password: String) {
        cleanErrors()

        nicknameValidation(nickname)
        emailAddressValidation(emailAddress)
        passwordValidation(password)

        checkErrors()
    }

    private fun cleanErrors() { _validationState.value = ValidationFormState() }

    private fun nicknameValidation(nickname: String) {
        val result = validateNicknameUseCase(nickname)

        if (result is ValidationResult.Error) {
            _validationState.value?.nicknameError = result.message
        }
    }

    private fun emailAddressValidation(emailAddress: String) {
        val result = validateEmailAddressUseCase(emailAddress)

        if (result is ValidationResult.Error) {
            _validationState.value?.emailAddressError = result.message
        }
    }

    private fun passwordValidation(password: String) {
        val result = validatePasswordUseCase(password)

        if (result is ValidationResult.Error) {
            _validationState.value?.passwordError = result.message
        }
    }

    private fun checkErrors() {
        if (_validationState.value == ValidationFormState()) {
            viewModelScope.launch { _registrationResult.send(ValidationResult.Success) }
        }
    }
}