package com.ruchad.dinedash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ruchad.dinedash.Fragments.NotificationBottomFragment
import com.ruchad.dinedash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var NavController = findNavController(R.id.nav_host_fragment)
        var bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setupWithNavController(NavController)

        binding.bellButton.setOnClickListener{
            val bottomsheetDialog = NotificationBottomFragment()
            bottomsheetDialog.show(supportFragmentManager, "Test")
        }

    }
}