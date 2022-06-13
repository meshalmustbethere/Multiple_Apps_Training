package com.example.firstapp.UI.todolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.UI.todolist.model.Todo
import com.example.firstapp.UI.todolist.util.TodoAdapter
import com.example.firstapp.databinding.ActivityTodolistBinding

class Todolist : AppCompatActivity() {
    private lateinit var binding: ActivityTodolistBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodolistBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val todoListSingleItem = mutableListOf(Todo("first to do",false))

        val adapter = TodoAdapter(todoListSingleItem)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val newTodoTitle = binding.etAddTodo.text.toString()
            val newTodo = Todo(newTodoTitle,false)


            todoListSingleItem.add(newTodo)
            adapter.notifyDataSetChanged()
            binding.etAddTodo.text.clear()
        }

    }
}