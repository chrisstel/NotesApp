package com.example.notes.ui.note.viewmodel

import android.text.format.DateFormat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.data.Note
import com.example.notes.domain.usecase.SaveNoteUseCase
import kotlinx.coroutines.launch
import java.util.Date

class NoteViewModel(
    private val saveNoteUseCase: SaveNoteUseCase
) : ViewModel() {

    fun saveNote(text: String) = viewModelScope.launch { saveNoteUseCase.save(createNote(text)) }
    private fun createNote(text: String) = Note(
        date = createCaption(),
        text = text
    )
    private fun createCaption(): String = DateFormat.format("hh:mm, MM.dd.yyyy", Date()).toString()
}