package com.ruchad.dinedash.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ruchad.dinedash.R
import com.ruchad.dinedash.adaptor.MenuAdapter
import com.ruchad.dinedash.databinding.FragmentBottomSheetBinding

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)


        binding.backButton.setOnClickListener {
            dismiss()
        }


        val foodName = listOf("Burger", "Pav Bhaji", "Pizza", "Pasta", "Burger", "Pav Bhaji", "Pizza", "Pasta", "Burger", "Pav Bhaji", "Pizza", "Pasta")
        val price = listOf("Rs 50", "Rs 40", "Rs 30", "Rs 80", "Rs 50", "Rs 40", "Rs 30", "Rs 80", "Rs 50", "Rs 40", "Rs 30", "Rs 80")
        val foodImg = listOf(
            R.drawable.pavbhaji,
            R.drawable.pavbhaji,
            R.drawable.pizza,
            R.drawable.pasta,
            R.drawable.pavbhaji,
            R.drawable.pavbhaji,
            R.drawable.pizza,
            R.drawable.pasta,
            R.drawable.pavbhaji,
            R.drawable.pavbhaji,
            R.drawable.pizza,
            R.drawable.pasta
        )
        val adapter = MenuAdapter(ArrayList(foodName), ArrayList(price), ArrayList(foodImg), requireContext())
        binding.recyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter


        return binding.root
    }
}