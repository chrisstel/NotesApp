package com.example.notes.data.database.room

import android.content.Context
import com.example.notes.data.database.NoteStorage
import com.example.notes.data.database.room.db.NoteDatabase
import com.example.notes.data.database.room.entity.RoomNote
import kotlinx.coroutines.flow.Flow

class RoomStorage(context: Context) : NoteStorage {
    private val dao = NoteDatabase.invoke(context).dao

    override fun getAllNotes(): Flow<List<RoomNote>> = dao.getAllNotes()

    override suspend fun save(note: RoomNote) = dao.insert(note)

    override suspend fun delete(note: RoomNote) = dao.delete(note)
}