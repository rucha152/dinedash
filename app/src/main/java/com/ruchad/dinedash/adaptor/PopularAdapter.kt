package com.ruchad.dinedash.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruchad.dinedash.DetailsActivity
import com.ruchad.dinedash.databinding.PopularItemBinding

class PopularAdapter (private val Items:List<String>, private val price:List<String>, private val image:List<Int>, private val requireContext: Context): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {
        val item = Items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price, images)

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName" ,Items[position]) //.get(position)
            intent.putExtra("MenuItemImage" ,image[position]) //.get(position)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return Items.size
    }

    class PopularViewHolder (private val binding : PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imageView = binding.image
        fun bind(item: String, price : String, images: Int) {
            binding.foodName.text = item
            binding.price.text = price
            imageView.setImageResource(images)
        }

    }
}