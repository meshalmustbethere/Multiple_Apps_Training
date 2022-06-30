package com.example.firstapp.UI.notesApp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.UI.notesApp.repository.NotesRepository

// class that knows how to create view models
class NotesViewModelFactory (private val repository: NotesRepository) : ViewModelProvider.NewInstanceFactory(){

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            // taking an object from NotesRepository class and return it to NotesViewModel class
            return NotesViewModel(repository) as T
        }
}