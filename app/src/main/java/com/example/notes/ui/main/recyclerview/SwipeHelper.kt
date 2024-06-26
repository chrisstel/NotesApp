package com.example.notes.ui.main.recyclerview

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.notes.domain.data.Note

class SwipeHelper(onSwiped: (Note) -> Unit) : ItemTouchHelper(SwipeCallback(onSwiped))