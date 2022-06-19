package com.example.firstapp.UI.notesApp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firstapp.UI.notesApp.model.Note

@Database(
    entities = [Note::class],
    version = 1
)

abstract class Notesdatabase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

/*  (companion object) = it is the alternative of the (static) word in java
    and we use (companion object) to tell the compiler not to create database with every run
    so it will create for us the database (Notesdatabase) just --> one time
    and to optimize the memory efficiency  */
    companion object {
        // @Volatile meaning that writes to this field are immediately made visible to other threads
        @Volatile
        private var instant: Notesdatabase? = null
        private val LOCK = Any()

        /* why invoke to call it when i need it */
        operator fun invoke(context: Context) = instant ?: synchronized(LOCK) {
            instant ?: createDatabase(context).also {
                 instant = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            Notesdatabase::class.java,
            "NotesDB.dp"
        ).build()
    }
}