package com.ruchad.dinedash.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ruchad.dinedash.DetailsActivity
import com.ruchad.dinedash.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItem: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private val menuImg: MutableList<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return menuItem.size
    }

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
                //set on click listener to open details of an item
                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItem[position]) //.get(position)
                intent.putExtra("MenuItemImage", menuImg[position]) //.get(position)
                intent.putExtra("MenuItemPrice", menuItemPrice[position])
                requireContext.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            binding.apply {
                foodNameMenu.text = menuItem[position]
                menuPrice.text = menuItemPrice[position]
                histImage.setImageResource(menuImg[position])


            }
        }


    }

    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}
