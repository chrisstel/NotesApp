package com.example.notes.data.database

import com.example.notes.domain.data.Note
import com.example.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteStorage: NoteStorage
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> = noteStorage.getAllNotes()

    override suspend fun save(note: Note) = noteStorage.save(note)

    override suspend fun delete(note: Note) = noteStorage.delete(note)
}