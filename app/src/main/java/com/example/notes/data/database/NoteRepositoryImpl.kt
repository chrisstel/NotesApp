package com.example.notes.data.database

import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteStorage: NoteStorage
) : NoteRepository {

    override fun getAllNotes(): Flow<List<RoomNote>> = noteStorage.getAllNotes()

    override suspend fun save(note: RoomNote) = noteStorage.save(note)

    override suspend fun delete(note: RoomNote) = noteStorage.delete(note)
}