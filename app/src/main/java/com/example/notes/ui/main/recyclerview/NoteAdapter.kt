package com.example.notes.ui.main.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.notes.domain.data.Note

class NoteAdapter : ListAdapter<Note, NoteViewHolder>(
    NoteDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder = NoteViewHolder.create(parent)

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(getItem(position))
}
