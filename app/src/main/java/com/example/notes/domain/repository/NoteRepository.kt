package com.example.notes.domain.repository

import com.example.notes.data.database.room.entity.RoomNote
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<List<RoomNote>>

    suspend fun save(note: RoomNote)

    suspend fun delete(note: RoomNote)
}