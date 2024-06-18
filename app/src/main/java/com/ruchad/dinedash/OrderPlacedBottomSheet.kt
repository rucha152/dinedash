package com.ruchad.dinedash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ruchad.dinedash.databinding.FragmentOrderPlacedBottomSheetBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class OrderPlacedBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentOrderPlacedBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderPlacedBottomSheetBinding.inflate(layoutInflater, container, false)
        binding.goHomeCongrats.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }


}