package com.example.notes.domain.repository

import com.example.notes.domain.data.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun save(note: Note)

    suspend fun delete(note: Note)
}