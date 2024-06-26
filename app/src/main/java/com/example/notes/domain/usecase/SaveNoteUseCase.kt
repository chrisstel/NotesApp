package com.example.notes.domain.usecase

import com.example.notes.domain.data.Note
import com.example.notes.domain.repository.NoteRepository

class SaveNoteUseCase(private val noteRepository: NoteRepository) {
    suspend fun save(note: Note) = noteRepository.save(note)
}