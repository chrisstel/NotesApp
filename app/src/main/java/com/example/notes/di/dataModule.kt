package com.example.notes.di

import com.example.notes.data.database.NoteRepositoryImpl
import com.example.notes.data.database.NoteStorage
import com.example.notes.data.database.room.RoomStorage
import com.example.notes.domain.repository.NoteRepository
import org.koin.dsl.module

val dataModule = module {

    single<NoteRepository> {
        NoteRepositoryImpl(noteStorage = get())
    }

    single<NoteStorage> {
        RoomStorage(context = get())
    }
}