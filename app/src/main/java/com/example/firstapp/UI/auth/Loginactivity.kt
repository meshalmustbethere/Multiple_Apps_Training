package com.example.firstapp.UI.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import com.example.firstapp.databinding.ActivityLoginactivityBinding

class Loginactivity : AppCompatActivity() {
    // binding is a feature that allows you to more easily write code that interacts with views.
    private lateinit var binding: ActivityLoginactivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding is a feature that allows you to more easily write code that interacts with views.

        binding = ActivityLoginactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}