package com.suyal.handovernewrideruis

import android.os.Bundle
//import android.support.v4.app.Fragment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation

class Earning_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_earning_, container, false)



      val rate_card = view.findViewById<ConstraintLayout>(R.id.ern_cons2)


        rate_card.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.rate_Card_Fragment)


        }







    return view
    }




}