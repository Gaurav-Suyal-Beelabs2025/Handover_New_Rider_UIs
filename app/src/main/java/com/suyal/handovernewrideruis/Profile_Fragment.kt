package com.suyal.handovernewrideruis

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class Profile_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_profile_, container, false)


          val handover_id_card=view.findViewById<ConstraintLayout>(R.id.layout_handover_id_card)
          val rate_card=view.findViewById<ConstraintLayout>(R.id.layout_documents_amp_details)
          val guidelines=view.findViewById<ConstraintLayout>(R.id.layout_my_performance)

         handover_id_card.setOnClickListener {

             Navigation.findNavController(view).navigate(R.id.handover_id_cardFragment)

         }


        rate_card.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.rate_Card_Fragment)

        }


        guidelines.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.guidelines_Fragment)

        }

        return view
    }


}