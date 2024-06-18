package com.ruchad.dinedash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruchad.dinedash.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayOutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.placeOrderButton.setOnClickListener(){
            val bottomSheetDialog = OrderPlacedBottomSheet()
            bottomSheetDialog.show(supportFragmentManager, "Test")

        }
    }
}