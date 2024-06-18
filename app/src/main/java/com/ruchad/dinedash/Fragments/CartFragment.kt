package com.ruchad.dinedash.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruchad.dinedash.OrderPlacedBottomSheet
import com.ruchad.dinedash.PayOutActivity
import com.ruchad.dinedash.R
import com.ruchad.dinedash.adaptor.CartAdaptor
import com.ruchad.dinedash.databinding.CartItemsBinding
import com.ruchad.dinedash.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Pizza", "Pasta", "Pav Bhaji", "Momo", "Pizza", "Pasta", "Pav Bhaji", "Momo")
        val cartItemPrice = listOf("50", "80", "100", "10", "50", "80", "100", "10")
        val images = listOf(R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza)
        val adapter =
            CartAdaptor(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(images))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

        binding.proceedButton.setOnClickListener{
            val intent = Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }




        return binding.root
    }


}