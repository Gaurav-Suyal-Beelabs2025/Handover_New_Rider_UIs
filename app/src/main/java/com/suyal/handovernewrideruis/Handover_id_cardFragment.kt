package com.suyal.handovernewrideruis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation

class Handover_id_cardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_handover_id_card, container, false)


         val arrow_back=view.findViewById<ImageView>(R.id.ic_arrow_back)


           arrow_back.setOnClickListener {

               Navigation.findNavController(view).navigate(R.id.profile_Fragment)

           }



    return view
    }


}