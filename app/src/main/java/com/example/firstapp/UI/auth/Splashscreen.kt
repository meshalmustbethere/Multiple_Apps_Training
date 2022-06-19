package com.example.firstapp.UI.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.firstapp.databinding.ActivitySplashscreenBinding

@Suppress("DEPRECATION")
class splashscreen : AppCompatActivity() {
    // binding is a feature that allows you to more easily write code that interacts with views.
    private lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding is a feature that allows you to more easily write code that interacts with views.
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed({
            val intent = Intent(this, Loginactivity::class.java)
            startActivity(intent)
            finish()
        }, 500)
    }
}

