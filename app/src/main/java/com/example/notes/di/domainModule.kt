package com.example.notes.di

import com.example.notes.domain.usecase.DeleteNoteUseCase
import com.example.notes.domain.usecase.GetAllNotesUseCase
import com.example.notes.domain.usecase.SaveNoteUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetAllNotesUseCase> {
        GetAllNotesUseCase(noteRepository = get())
    }

    factory<SaveNoteUseCase> {
        SaveNoteUseCase(noteRepository = get())
    }

    factory<DeleteNoteUseCase> {
        DeleteNoteUseCase(noteRepository = get())
    }
}