package com.example.firstapp.UI.todoapiapp.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.UI.todoapiapp.model.TodoListApiDataItem
import com.example.firstapp.databinding.ItemPostlistapiBinding


class TodoListApiAdapter : RecyclerView.Adapter<TodoListApiAdapter.TodoListApiViewHolder> (){
    inner class TodoListApiViewHolder(val binding: ItemPostlistapiBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<TodoListApiDataItem>(){
        override fun areItemsTheSame(oldItem: TodoListApiDataItem, newItem: TodoListApiDataItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: TodoListApiDataItem, newItem: TodoListApiDataItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ  = AsyncListDiffer(this,diffCallBack)
    var posts : List<TodoListApiDataItem>
        get() = differ.currentList
        set(value) { differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListApiViewHolder {
        return TodoListApiViewHolder(ItemPostlistapiBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoListApiViewHolder, position: Int) {
        holder.binding.apply {
            val singlePost = posts[position]
            txPostApiTitle.text = singlePost.title
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}


