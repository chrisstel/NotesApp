package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {
    private lateinit var _binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentAddNoteBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancel()
        saveNote()
    }


    private fun cancel() = views {
        cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_mainFragment)
        }
    }
    private fun saveNote() = views {
        saveNoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_mainFragment)
        }
    }
    private fun<T> views(block: FragmentAddNoteBinding.() -> T): T? = _binding.block()
}