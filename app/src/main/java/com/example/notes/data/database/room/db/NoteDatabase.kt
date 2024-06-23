package com.example.notes.data.database.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.data.database.room.dao.NoteDao
import com.example.notes.data.database.room.entity.RoomNote

@Database(entities = [RoomNote::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract val dao: NoteDao

    companion object {
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "notes-database"
        ).build()
    }
}