package com.ruchad.dinedash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruchad.dinedash.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImg= intent.getIntExtra("MenuItemImage", 0)
        val foodPrice = intent.getStringExtra("MenuItemPrice")
        1
        binding.foodNamePlaceholder.text = foodName
        binding.foodImg.setImageResource(foodImg)
        binding.foodPrice.text = foodPrice

        binding.backButton.setOnClickListener{
            finish()
        }

    }
}