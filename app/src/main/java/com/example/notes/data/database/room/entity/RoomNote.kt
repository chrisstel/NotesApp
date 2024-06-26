package com.example.notes.data.database.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class RoomNote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("caption") val caption: String,
    @ColumnInfo("text") val text: String
)