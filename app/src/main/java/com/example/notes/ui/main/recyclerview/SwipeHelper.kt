package com.example.notes.ui.main.recyclerview

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.notes.data.database.room.entity.RoomNote

class SwipeHelper(onSwiped: (RoomNote) -> Unit) : ItemTouchHelper(SwipeCallback(onSwiped))