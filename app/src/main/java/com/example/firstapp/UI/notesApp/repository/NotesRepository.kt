package com.example.firstapp.UI.notesApp.repository

import com.example.firstapp.UI.notesApp.db.Notesdatabase
import com.example.firstapp.UI.notesApp.model.Note

/*
* the objective of this class : bridge between the (database) and the (ViewModel)
*                  DATABASE <---talk to---- [REPOSITORY] ---talk to---- > VIEWMODEL
* */
class NotesRepository (private val db:Notesdatabase){

    fun upsert(item: Note) = db.getNotesDao().upsert(item)
    fun getAllNotesItem() = db.getNotesDao().getAllNotesItem()
}