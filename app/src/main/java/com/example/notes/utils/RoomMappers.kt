package com.example.notes.utils

import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.domain.data.Note

fun RoomNote.toDomain(): Note = Note(
    id = this.id,
    date = this.caption,
    text = this.text
)

fun Note.fromDomain(): RoomNote = RoomNote(
    id = this.id,
    caption = this.date,
    text = this.text
)