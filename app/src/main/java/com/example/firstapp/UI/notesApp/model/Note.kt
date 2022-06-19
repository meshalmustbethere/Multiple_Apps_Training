package com.example.firstapp.UI.notesApp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
    The original data class declaration:
      like this: data class Note(val title: String)

    The annotation (@) -->  is a signature to the next line
*/
@Entity(tableName = "Notes_items")
data class Note(
    @ColumnInfo(name = "note_title")
    var title: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}