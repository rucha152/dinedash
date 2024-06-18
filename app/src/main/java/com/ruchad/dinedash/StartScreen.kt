package com.ruchad.dinedash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ruchad.dinedash.databinding.ActivityStartScreenBinding

class StartScreen : AppCompatActivity() {

    private lateinit var binding: ActivityStartScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the binding variable before accessing its properties
        binding.buttStartScreen.setOnClickListener {
            val intent = Intent(this@StartScreen, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
