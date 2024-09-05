package com.example.notes.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentNoteDetailsBinding
import com.example.notes.domain.data.Note

class NoteDetailsFragment : Fragment() {
    private lateinit var _binding: FragmentNoteDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentNoteDetailsBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showNoteDetails()
        goBack()

        views {
            editNote.setOnClickListener {
                it.visibility = INVISIBLE
                _binding.saveNoteButton.visibility = VISIBLE
            }

            saveNoteButton.setOnClickListener {
                it.visibility = INVISIBLE
                _binding.editNote.visibility = VISIBLE
            }
        }
    }

    private fun showNoteDetails() {

        //TODO
        arguments?.getSerializable("note", Note::class.java)?.let { note ->
            views {
                noteDate.text = note.date
                noteText.text = note.text
            }
        }
    }

    private fun goBack() = views {
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_noteDetailsFragment_to_mainFragment)
        }
    }

    private fun <T> views(block: FragmentNoteDetailsBinding.() -> T): T = _binding.block()
}