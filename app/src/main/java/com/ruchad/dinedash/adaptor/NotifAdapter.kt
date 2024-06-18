package com.ruchad.dinedash.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.ruchad.dinedash.databinding.NotifItemBinding

class NotifAdapter(private val notif_img: ArrayList<Int>, private val notif_text: ArrayList<String>) : Adapter<NotifAdapter.NotifViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifViewHolder {
        val binding = NotifItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotifViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notif_text.size
    }

    override fun onBindViewHolder(holder: NotifViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class NotifViewHolder(private val binding : NotifItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                binding.notifImage.setImageResource(notif_img[position])
                binding.foodNameNotif.text = notif_text[position]
            }

        }
    }
}