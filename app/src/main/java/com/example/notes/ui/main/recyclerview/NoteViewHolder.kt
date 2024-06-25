package com.example.notes.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.databinding.NoteItemBinding

class NoteViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
    var item: RoomNote? = null
        private set

    companion object {
        fun create(parent: ViewGroup) = NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let(::NoteViewHolder)
    }

    fun bind(note: RoomNote) {
        this.item = note

        views {
            TVCaption.text = note.caption
            TVText.text = note.text
        }
    }

    private fun<T> views(block: NoteItemBinding.() -> T): T? = binding.block()
}