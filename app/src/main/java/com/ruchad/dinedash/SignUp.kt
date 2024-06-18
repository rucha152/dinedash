package com.ruchad.dinedash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruchad.dinedash.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.existentAccActivityLogin.setOnClickListener{
            val intent = Intent(this@SignUp, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.loginActivityLogin.setOnClickListener {
            val intent = Intent(this@SignUp, ChooseLocation::class.java)
            startActivity(intent)
        }
    }
}