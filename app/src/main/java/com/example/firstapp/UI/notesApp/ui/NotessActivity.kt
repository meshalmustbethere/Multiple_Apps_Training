package com.example.firstapp.UI.notesApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.UI.notesApp.db.Notesdatabase
import com.example.firstapp.UI.notesApp.model.Note
import com.example.firstapp.UI.notesApp.repository.NotesRepository
import com.example.firstapp.UI.notesApp.util.NotesAdapter
import com.example.firstapp.UI.todolist.model.Todo
import com.example.firstapp.UI.todolist.util.TodoAdapter
import com.example.firstapp.databinding.ActivityNotessBinding
import com.example.firstapp.databinding.ActivityTodolistBinding

class NotessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityNotessBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // the adding here ...
        val database = Notesdatabase(this)
        val repository = NotesRepository(database)
        val factory = NotesViewModelFactory(repository)

        // line 38 was using (ViewModelProviders.of) with s, is there any difference
        val viewModel = ViewModelProvider(this,factory).get(NotesViewModel::class.java)

        //val notesSingleItem = mutableListOf(Note("first to do"))
        val adapter = NotesAdapter(listOf(),viewModel)

        binding.rvNote.adapter = adapter
        binding.rvNote.layoutManager = LinearLayoutManager(this)

        viewModel.getAllNotesItems().observe(this, Observer {
            adapter.notes = it
            adapter.notifyDataSetChanged() // to update the list
        })

        binding.btnAddNote.setOnClickListener {
            val newNoteTitle = binding.etAddNote.text.toString()
            val newNote = Note(newNoteTitle)
            viewModel.upsert(newNote)
            //notesSingleItem.add(newNote)
            adapter.notifyDataSetChanged()
            binding.etAddNote.text.clear()
        }
    }
}