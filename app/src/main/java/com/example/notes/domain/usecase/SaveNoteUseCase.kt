package com.example.notes.domain.usecase

import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.domain.repository.NoteRepository

class SaveNoteUseCase(private val noteRepository: NoteRepository) {
    suspend fun save(note: RoomNote) = noteRepository.save(note)
}