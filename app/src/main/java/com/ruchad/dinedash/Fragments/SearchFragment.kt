package com.ruchad.dinedash.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruchad.dinedash.R
import com.ruchad.dinedash.adaptor.MenuAdapter
import com.ruchad.dinedash.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var adapter: MenuAdapter

    private val MenuFoodName = listOf(
        "Burger",
        "Pav Bhaji",
        "Pizza",
        "Pasta",
        "Burger",
        "Pav Bhaji",
        "Pizza",
        "Pasta",
        "Burger",
        "Pav Bhaji",
        "Pizza",
        "Pasta"
    )
    val MenuItemPrice = listOf(
        "Rs 50",
        "Rs 40",
        "Rs 30",
        "Rs 80",
        "Rs 50",
        "Rs 40",
        "Rs 30",
        "Rs 80",
        "Rs 50",
        "Rs 40",
        "Rs 30",
        "Rs 80"
    )
    val MenuFoodImg = listOf(
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

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage, requireContext())
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.adapter = adapter

        //setup for search view
        setupSearchView()

        //show all menu items
        showAllMenuItems()

        return binding.root
    }

    private fun showAllMenuItems() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(MenuFoodName)
        filteredMenuItemPrice.addAll(MenuItemPrice)
        filteredMenuImage.addAll(MenuFoodImg)

        adapter.notifyDataSetChanged()


    }


    private fun setupSearchView() {
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {
                filterMenuItems(p0)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                filterMenuItems(newText)
                return true


            }
        })
    }

    private fun filterMenuItems(p0: String?) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        MenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(p0.toString(), ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(MenuItemPrice[index])
                filteredMenuImage.add(MenuFoodImg[index])
            }

        }
        adapter.notifyDataSetChanged()
    }

}