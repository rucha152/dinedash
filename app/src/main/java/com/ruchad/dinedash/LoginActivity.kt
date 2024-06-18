package com.ruchad.dinedash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ruchad.dinedash.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginActivityLogin.setOnClickListener{
            val intent = Intent(this@LoginActivity, ChooseLocation::class.java)
                startActivity(intent)
        }
        binding.noAccActivityLogin.setOnClickListener{
                val intent = Intent(this@LoginActivity, SignUp::class.java)
                startActivity(intent)
            }

    }
}