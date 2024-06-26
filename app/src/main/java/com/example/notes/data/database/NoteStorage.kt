package com.example.notes.data.database

import com.example.notes.domain.data.Note
import kotlinx.coroutines.flow.Flow

interface NoteStorage {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun save(note: Note)

    suspend fun delete(note: Note)
}