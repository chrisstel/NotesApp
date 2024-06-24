package com.example.notes.ui.main

import android.text.format.DateFormat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.database.room.entity.RoomNote
import com.example.notes.domain.usecase.DeleteNoteUseCase
import com.example.notes.domain.usecase.GetAllNotesUseCase
import com.example.notes.domain.usecase.SaveNoteUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val saveNoteUseCase: SaveNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase

) : ViewModel() {

    val notes = getAllNotesUseCase.getAll().asLiveDataFlow()

    fun saveNote(text: String) = viewModelScope.launch {
        saveNoteUseCase.save(createNote(text))
    }

    fun deleteNote(note: RoomNote) = viewModelScope.launch {
        deleteNoteUseCase.delete(note)
    }

    private fun createNote(text: String) = RoomNote(
        caption = createCaption(),
        text = text
    )
    private fun createCaption(): String = DateFormat.format("hh:mm:ss, MM dd yyyy", Date()).toString()
    private fun <T> Flow<T>.asLiveDataFlow() = shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)
}