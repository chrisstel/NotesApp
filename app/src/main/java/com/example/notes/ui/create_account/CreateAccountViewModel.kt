package com.example.notes.ui.create_account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.domain.data.ValidationResult
import com.example.notes.domain.usecase.ValidateEmailAddressUseCase
import com.example.notes.domain.usecase.ValidateNicknameUseCase
import com.example.notes.domain.usecase.ValidatePasswordUseCase

class CreateAccountViewModel(
    private val validateNicknameUseCase: ValidateNicknameUseCase,
    private val validateEmailAddressUseCase: ValidateEmailAddressUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<ValidationResult>()
    val signUpResult: LiveData<ValidationResult> = _liveData
}