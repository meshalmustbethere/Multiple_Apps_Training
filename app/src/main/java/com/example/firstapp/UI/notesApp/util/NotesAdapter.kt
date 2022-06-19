package com.example.firstapp.UI.notesApp.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.UI.notesApp.model.Note
import com.example.firstapp.UI.notesApp.ui.NotesViewModel
import com.example.firstapp.UI.todolist.util.TodoAdapter
import com.example.firstapp.databinding.ItemNoteBinding
import com.example.firstapp.databinding.ItemTodoBinding


class NotesAdapter(var notes: List<Note>, private val viewModel: NotesViewModel) : RecyclerView.Adapter<NotesAdapter.NoteHolderView>() {

    //inner class TodoHolderView(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)
    inner class NoteHolderView(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.NoteHolderView {
        return NoteHolderView(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteHolderView, position: Int) {
        holder.binding.apply { txtNote.text = notes[position].title }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}