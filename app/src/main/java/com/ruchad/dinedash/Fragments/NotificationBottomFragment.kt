package com.ruchad.dinedash.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ruchad.dinedash.R
import com.ruchad.dinedash.adaptor.NotifAdapter
import com.ruchad.dinedash.databinding.FragmentNotificationBottomBinding

class NotificationBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater, container, false)
        val notifications = listOf(
            "Order has been cancelled successfully",
            "Order has been collected by the delivery executive",
            "Your order has been placed!"
        )
        val notification_images = listOf(
            R.drawable.notif_cancelled,
            R.drawable.baseline_delivery_dining_24,
            R.drawable.order_placed
        )
        val adapter = NotifAdapter(
            ArrayList(notification_images),
            ArrayList(notifications)
        )
        binding.recyclerViewNotif.adapter = adapter
        binding.recyclerViewNotif.layoutManager = LinearLayoutManager(requireContext())



        return binding.root
    }


}