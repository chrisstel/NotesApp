package com.example.notes.domain.usecase

import com.example.notes.domain.data.Note
import com.example.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {
    fun getAll(): Flow<List<Note>> = noteRepository.getAllNotes()
}