package com.ruchad.dinedash.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruchad.dinedash.R
import com.ruchad.dinedash.adaptor.HistoryAdapter
import com.ruchad.dinedash.databinding.FragmentHistoryBinding
import com.ruchad.dinedash.databinding.FragmentHomeBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {
        val buyAgainFoodName = arrayListOf<String>(
            "Pizza",
            "Pasta",
            "Pav Bhaji",
            "Momo",
            "Pizza",
            "Pasta",
            "Pav Bhaji"
        )
        val buyAgainFoodPrice = arrayListOf<String>("50", "80", "100", "10", "50", "80", "100")
        val buyAgainFoodImg = arrayListOf<Int>(
            R.drawable.pizza,
            R.drawable.pizza,
            R.drawable.pizza,
            R.drawable.pizza,
            R.drawable.pizza,
            R.drawable.pizza,
            R.drawable.pizza
        )

        adapter = HistoryAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImg)
        binding.recyclerViewHistory.adapter = adapter
        binding.recyclerViewHistory.layoutManager = LinearLayoutManager(requireContext())


    }


}