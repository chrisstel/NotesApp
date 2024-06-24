package com.example.notes.data.database.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notes.data.database.room.entity.RoomNote
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<RoomNote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: RoomNote)

    @Delete
    suspend fun delete(note: RoomNote)

}