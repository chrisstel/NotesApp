package com.example.notes.ui.main

import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.notes.databinding.FragmentMainBinding
import com.example.notes.domain.data.Note
import com.example.notes.ui.main.recyclerview.NoteAdapter
import com.example.notes.ui.main.recyclerview.SwipeHelper
import com.example.notes.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by viewModel()
    private val adapter: NoteAdapter? get() = views { recyclerViewNotes.adapter as? NoteAdapter }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainBinding.inflate(layoutInflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {
            recyclerViewNotes.adapter = NoteAdapter()
            SwipeHelper(viewModel::deleteNote).attachToRecyclerView(recyclerViewNotes)
            imageViewAddNote.setOnClickListener {
                saveNote()
            }
        }

        viewModel.notes.onEach(::renderNotes).launchIn(lifecycleScope)
    }

    private fun renderNotes(notes: List<Note>) { adapter?.submitList(notes) }

    private fun saveNote() {
        views {
            val text = editTextAddNote.text.toString().takeIf { it.isNotBlank() } ?: return@views

            viewModel.saveNote(text = text)
            editTextAddNote.text.clear()
        }
    }

    private fun <T> views(block: FragmentMainBinding.() -> T): T? = binding?.block()
}
