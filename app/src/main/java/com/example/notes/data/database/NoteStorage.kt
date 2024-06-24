package com.example.notes.data.database

import com.example.notes.data.database.room.entity.RoomNote
import kotlinx.coroutines.flow.Flow

interface NoteStorage {

    fun getAllNotes(): Flow<List<RoomNote>>

    suspend fun save(note: RoomNote)

    suspend fun delete(note: RoomNote)
}