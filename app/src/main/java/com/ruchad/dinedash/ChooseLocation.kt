package com.ruchad.dinedash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ruchad.dinedash.databinding.ActivityChooseLocationBinding

class ChooseLocation : AppCompatActivity() {

    private lateinit var binding : ActivityChooseLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val locationList = arrayOf("Koregaon Park", "Kothrud", "Hinjewadi", "Baner", "Viman Nagar", "Aundh", "Wakad")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listlocation
        autoCompleteTextView.setAdapter(adapter)
    }
}