package com.suyal.handovernewrideruis

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class Selfi_Fragment : Fragment() {

    val amount = 20;

    private val imageuri = 99;
    private val REQUEST_CODE1 = 69
    lateinit var  set_image: ImageView;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(com.suyal.handovernewrideruis.R.layout.fragment_selfi_, container, false)

        val click_button=view.findViewById<TextView>(com.suyal.handovernewrideruis.R.id.txt_click)
            set_image=view.findViewById<ImageView>(com.suyal.handovernewrideruis.R.id.img_setimage)
        val back_page=view.findViewById<ImageView>(com.suyal.handovernewrideruis.R.id.img_arrow_back)
        val submit_button=view.findViewById<TextView>(com.suyal.handovernewrideruis.R.id.txt_submit)


      click_button.setOnClickListener {

          val takePictureIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
           startActivityForResult(takePictureIntent, REQUEST_CODE1)

      }


        submit_button.setOnClickListener {


            val bundle = Bundle()


            bundle.putString("uri", imageuri.toString())
            Navigation.findNavController(view).navigate(com.suyal.handovernewrideruis.R.id.profile_Fragment, bundle)



//            val navController = Navigation.findNavController(requireContext() as Activity,com.suyal.handovernewrideruis.R.id.profile_Fragment)
//            // Create the Bundle to pass, you can put String, Integer, or serializable object
//            // Create the Bundle to pass, you can put String, Integer, or serializable object
//            val bundle = Bundle()
//            bundle.putString("link", "http://yourlink.com/policy")
//            bundle.putSerializable("USER", "user") // Serializable Object
//
//            navController.navigate( com.suyal.handovernewrideruis.R.id.profile_Fragment,bundle)

        }


        back_page.setOnClickListener {





        }




    return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) =

        if (requestCode == REQUEST_CODE1 && resultCode == Activity.RESULT_OK) {
            val takenImage = data?.extras?.get("data") as Bitmap

            set_image.setImageBitmap(takenImage) //Foto wird im ImageView dargestellt

        }


        else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
