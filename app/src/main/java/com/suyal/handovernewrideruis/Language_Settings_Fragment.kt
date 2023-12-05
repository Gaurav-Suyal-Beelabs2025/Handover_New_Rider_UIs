package com.suyal.handovernewrideruis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation

class Language_Settings_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_language__settings_, container, false)

    val back_button=view.findViewById<ImageView>(R.id.back_btn)



        back_button.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.profile_Fragment)

        }



        return view
    }

}