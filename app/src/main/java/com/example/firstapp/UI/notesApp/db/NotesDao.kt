package com.example.firstapp.UI.notesApp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firstapp.UI.notesApp.model.Note

/*why interface?
because, the (interface) is the connection between the interface and the application all the methods
and functions, also can inherit multiple times not like original inherit in oop
- it's abstract by default
- methods inside the interface also --> abstract by default, so I can call it the methods in another classes

     @Dao : Stand for --> [ Data Access Object ]
*/
@Dao
interface NotesDao{
    // OnConflictStrategy : replace the (old content) to the --> (new content )
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: Note) // suspend to make it visible to the thread

    @Query("SELECT * FROM Notes_items")
    fun getAllNotesItem(): LiveData<List<Note>>
    /*
    Live data is a class to save the data more closely to fetch it faster every time
    */
}


