package com.example.notes.data.database.room

import android.content.Context
import com.example.notes.data.database.NoteStorage
import com.example.notes.data.database.room.db.NoteDatabase
import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.domain.data.Note
import com.example.notes.utils.fromDomain
import com.example.notes.utils.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomStorage(context: Context) : NoteStorage {
    private val dao = NoteDatabase.invoke(context).dao

    override fun getAllNotes(): Flow<List<Note>> = dao.getAllNotes().map { noteList -> noteList.map(RoomNote::toDomain) }

    override suspend fun save(note: Note) = dao.insert(note.fromDomain())

    override suspend fun delete(note: Note) = dao.delete(note.fromDomain())
}