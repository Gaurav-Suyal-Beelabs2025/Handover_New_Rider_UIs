package com.suyal.handovernewrideruis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.suyal.handovernewrideruis.databinding.FragmentNameBinding


class Name_Fragment : Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        val view = binding.root

          binding.txtSubmit.setOnClickListener {


              val name =binding.editTextRidername.text.toString()
              val user = User(name)


              // create an action and pass the required user object to it
              // If you can not find the RegistrationDirection try to "Build project"
            //  val action = RegistrationDirections.actionRegistrationToDetails(user)

              // this will navigate the current fragment i.e
              // Registration to the Detail fragment
            //  findNavController().navigate(
               //   action

            //  )
          }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
