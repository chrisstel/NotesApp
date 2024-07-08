package com.example.notes.di

import com.example.notes.ui.create_account.CreateAccountViewModel
import com.example.notes.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getAllNotesUseCase = get(),
            saveNoteUseCase = get(),
            deleteNoteUseCase = get()
        )
    }

    viewModel<CreateAccountViewModel> {
        CreateAccountViewModel(
            validateNicknameUseCase = get(),
            validateEmailAddressUseCase = get(),
            validatePasswordUseCase = get()
        )
    }
}