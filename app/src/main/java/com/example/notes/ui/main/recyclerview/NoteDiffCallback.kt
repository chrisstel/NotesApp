package com.example.notes.ui.main.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.notes.domain.data.Note

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem
}