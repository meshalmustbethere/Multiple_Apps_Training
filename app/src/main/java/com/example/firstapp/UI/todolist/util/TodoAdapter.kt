package com.example.firstapp.UI.todolist.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.UI.todolist.model.Todo
import com.example.firstapp.databinding.ItemTodoBinding

class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoHolderView>() {

    inner class TodoHolderView(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    // 1 to set the data on the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolderView {
        return TodoHolderView(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // 2 to bind on the view
    // TodoHolder view :
    // postion
    override fun onBindViewHolder(holder: TodoHolderView, position: Int) {
        holder.binding.apply {
            txTodotitle.text = todos[position].title
            chkTodoDone.isChecked = todos[position].isChecked
        }
    }

    // 3 this function is used to count the items on the screen and make the size flexible
    override fun getItemCount(): Int {
        return todos.size
    }
}