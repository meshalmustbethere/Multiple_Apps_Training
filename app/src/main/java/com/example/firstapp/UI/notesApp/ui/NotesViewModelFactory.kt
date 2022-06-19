package com.example.firstapp.UI.notesApp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.UI.notesApp.repository.NotesRepository

class NotesViewModelFactory (private val repository: NotesRepository) : ViewModelProvider.NewInstanceFactory(){

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return NotesViewModel(repository) as T
        }
}

/*

package com.apps.fullandroidcourseclassa.shoppinglistapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.fullandroidcourseclassa.shoppinglistapp.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository) :ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}*/