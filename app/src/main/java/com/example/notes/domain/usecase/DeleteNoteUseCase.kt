package com.example.notes.domain.usecase

import com.example.notes.domain.data.Note
import com.example.notes.domain.repository.NoteRepository

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {
    suspend fun delete(note: Note) = noteRepository.delete(note)
}