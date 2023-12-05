package com.suyal.handovernewrideruis

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation


class Selfi_Fragment : Fragment() {

    private val REQUEST_CODE = 69
    lateinit var  set_image: ImageView;





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_selfi_, container, false)




        val click_button=view.findViewById<TextView>(R.id.txt_click)
         set_image=view.findViewById<ImageView>(R.id.img_setimage)
        val back_page=view.findViewById<ImageView>(R.id.img_arrow_back)


      click_button.setOnClickListener {

          val takePictureIntent =  Intent(MediaStore.ACTION_IMAGE_CAPTURE)
           startActivityForResult(takePictureIntent, REQUEST_CODE)



      }


        back_page.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.profile_Fragment)

        }






    return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) =

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val takenImage = data?.extras?.get("data") as Bitmap
            set_image.setImageBitmap(takenImage) //Foto wird im ImageView dargestellt

        }


        else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
