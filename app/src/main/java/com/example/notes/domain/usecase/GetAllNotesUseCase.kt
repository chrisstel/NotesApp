package com.example.notes.domain.usecase

import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {
    fun getAll(): Flow<List<RoomNote>> = noteRepository.getAllNotes()
}