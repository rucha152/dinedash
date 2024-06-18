package com.ruchad.dinedash.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruchad.dinedash.databinding.BuyAgainItemsBinding
import com.ruchad.dinedash.databinding.FragmentHistoryBinding

class HistoryAdapter(private val buyAgainFoodName : ArrayList<String>,
                     private val buyAgainFoodPrice: ArrayList<String>,
                     private val buyAgainFoodImg: ArrayList<Int>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = BuyAgainItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(buyAgainFoodName[position], buyAgainFoodPrice[position], buyAgainFoodImg[position])
    }

    override fun getItemCount(): Int {
        return buyAgainFoodName.size

    }


    class HistoryViewHolder(private val binding: BuyAgainItemsBinding) : RecyclerView.ViewHolder
        (binding.root){
        fun bind(name: String, price: String, img: Int) {
            binding.foodNameHistory.text = name
            binding.menuPrice.text = price
            binding.histImage.setImageResource(img)
        }

    }

}