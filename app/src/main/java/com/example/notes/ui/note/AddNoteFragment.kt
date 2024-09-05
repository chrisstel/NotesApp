package com.example.notes.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNoteBinding
import com.example.notes.ui.note.viewmodel.NoteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNoteFragment : Fragment() {
    private lateinit var _binding: FragmentAddNoteBinding
    private val noteViewModel: NoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentAddNoteBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {
            backButton.setOnClickListener { goBack() }
            saveNoteButton.setOnClickListener { saveNote() }
        }
    }

    private fun goBack() = views {
        findNavController().navigate(R.id.action_addNoteFragment_to_mainFragment)
    }

    private fun saveNote() = views {
        val text = noteText.text.toString()

        noteViewModel.saveNote(text = text)
        findNavController().navigate(R.id.action_addNoteFragment_to_mainFragment)
    }

    private fun <T> views(block: FragmentAddNoteBinding.() -> T): T? = _binding.block()
}