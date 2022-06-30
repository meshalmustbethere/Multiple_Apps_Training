package com.example.firstapp.UI.todoapiapp.service



import com.example.firstapp.UI.todoapiapp.model.TodoListApiDataItem
import retrofit2.Response
import retrofit2.http.GET

interface TodoListApi {

    @GET("/posts")
    suspend fun getPosts() : Response<List<TodoListApiDataItem>>
}