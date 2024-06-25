package com.example.notes.ui.main.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.notes.data.database.room.entity.RoomNote

class NoteDiffCallback : DiffUtil.ItemCallback<RoomNote>() {

    override fun areItemsTheSame(oldItem: RoomNote, newItem: RoomNote): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RoomNote, newItem: RoomNote): Boolean = oldItem == newItem
}