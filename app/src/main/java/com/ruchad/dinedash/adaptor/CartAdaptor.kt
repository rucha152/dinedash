package com.ruchad.dinedash.adaptor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruchad.dinedash.databinding.CartItemsBinding

class CartAdaptor(
    private val CartItem: MutableList<String>,
    private val CartItemPrice: MutableList<String>,
    private var cartImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdaptor.CartViewHolder>() {

    private val itemQuantities = IntArray(CartItem.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        var binding = CartItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return CartItem.size
    }

    inner class CartViewHolder(private val binding: CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                foodName.text = CartItem[position]
                foodPrice.text = CartItemPrice[position]
                imageView.setImageResource(cartImage[position])
                qty.text = quantity.toString()

                add.setOnClickListener {
                    increaseqty(position)
                }

                sub.setOnClickListener {
                    decreaseqty(position)
                }

                delete.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(position)
                    }
                }
            }
        }

        private fun decreaseqty(position: Int) {
            if (itemQuantities[position] >= 1) {
                itemQuantities[position]--
                binding.qty.text = itemQuantities[position].toString()
            }
        }

        private fun increaseqty(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.qty.text = itemQuantities[position].toString()
            }

        }

        private fun deleteItem(position: Int) {
            CartItem.removeAt(position)
            CartItemPrice.removeAt(position)
            cartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, CartItem.size)
        }
    }

}