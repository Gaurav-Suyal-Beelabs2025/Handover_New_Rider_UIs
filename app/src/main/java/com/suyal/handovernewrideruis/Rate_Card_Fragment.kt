package com.suyal.handovernewrideruis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation


class Rate_Card_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_rate__card_, container, false)

     val more_info =view.findViewById<TextView>(R.id.txt_more_info)
     val back_button=view.findViewById<ImageView>(R.id.ic_arrow_back)

     more_info.setOnClickListener {

        Navigation.findNavController(view).navigate(R.id.want_to_know_bottomsheet)

     }

      back_button.setOnClickListener {

          Navigation.findNavController(view).navigate(R.id.earning_Fragment)

      }



   return view
    }


}