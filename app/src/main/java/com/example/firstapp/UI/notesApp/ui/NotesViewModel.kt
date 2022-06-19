package com.example.firstapp.UI.notesApp.ui

import androidx.lifecycle.ViewModel
import com.example.firstapp.UI.notesApp.model.Note
import com.example.firstapp.UI.notesApp.repository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (private val repository: NotesRepository): ViewModel(){
    fun upsert(item: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun getAllNotesItems() = repository.getAllNotesItem()
}
