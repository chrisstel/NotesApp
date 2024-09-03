package com.example.notes.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.NoteItemBinding
import com.example.notes.domain.data.Note

class NoteViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
    var item: Note? = null
        private set

    companion object {
        var onClick: ((Note) -> Unit)? = null

        fun create(parent: ViewGroup) = NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let(::NoteViewHolder)
    }

    fun bind(note: Note) {
        this.item = note

        views {
            TVCaption.text = note.caption
            TVText.text = note.text
            root.setOnClickListener { onClick?.invoke(note) }
        }
    }

    private fun<T> views(block: NoteItemBinding.() -> T): T? = binding.block()
}