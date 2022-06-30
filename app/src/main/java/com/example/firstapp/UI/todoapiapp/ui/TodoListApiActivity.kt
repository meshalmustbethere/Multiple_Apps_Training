package com.example.firstapp.UI.todoapiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.UI.todoapiapp.service.RetrofitInstanceTodoListApi
import com.example.firstapp.UI.todoapiapp.ui.utils.TodoListApiAdapter
import com.example.firstapp.databinding.ActivityPostListApiBinding
import retrofit2.HttpException
import java.io.IOException

class TodoListApiActivity : AppCompatActivity() {
    private lateinit var todoListApiAdapter : TodoListApiAdapter
    private lateinit var binding : ActivityPostListApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostListApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBarPostListApi.isVisible= true // Show Progress Bar

            val response = try {
                RetrofitInstanceTodoListApi.api.getPosts() // Getting List of Todos Data
            } catch (e: IOException) {
                Log.d("TodoListApiActivity", "You may have no internet connection")
                binding.progressBarPostListApi.isVisible = false // Disable Progress Bar
                return@launchWhenCreated

            } catch (e: HttpException) {
                Log.d("TodoListApiActivity", "Unexpected Response")
                binding.progressBarPostListApi.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                todoListApiAdapter.posts = response.body()!!
            } else {
                Log.d("TodoListApiActivity", "Response is not successful")
            }
            binding.progressBarPostListApi.isVisible = false // Disable Progress Bar
        }

    }
        // layout-manager with recycler view
    private fun setupRecyclerView() = binding.rvPostListApi.apply {
        todoListApiAdapter = TodoListApiAdapter()
        adapter = todoListApiAdapter
        layoutManager = LinearLayoutManager(this@TodoListApiActivity)
    }

}