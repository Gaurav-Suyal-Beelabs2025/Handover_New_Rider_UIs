package com.suyal.handovernewrideruis

import android.R.attr.data
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialog


class Profile_Fragment : Fragment() {

    private val REQUEST_CODE = 69
    private val GALLERY_REQEST_CODE=100;
    private lateinit var ConstraintLayout:ConstraintLayout
    lateinit var  set_image:ImageView;
    lateinit var post_image: ImageView;
    lateinit var camera: ImageView ;
    private var imageUri: Uri? = null
    val Fragment.packageManager get() = activity?.packageManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) =

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val takenImage = data?.extras?.get("data") as Bitmap
            set_image.setImageBitmap(takenImage) //Foto wird im ImageView dargestellt

        }
           else if (requestCode == GALLERY_REQEST_CODE && resultCode == Activity.RESULT_OK){

            val selectedImageUri = data?.data
            set_image.setImageURI(selectedImageUri)


           }

        else {
                super.onActivityResult(requestCode, resultCode, data)
            }

            override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                // Inflate the layout for this fragment
                val view = inflater.inflate(R.layout.fragment_profile_, container, false)


                val handover_id_card =
                    view.findViewById<ConstraintLayout>(R.id.layout_handover_id_card)

//                val rate_card =
//                    view.findViewById<ConstraintLayout>(R.id.layout_documents_amp_details)
                val document_details=view.findViewById<ConstraintLayout>(R.id.layout_documents_amp_details)
                val guidelines = view.findViewById<ConstraintLayout>(R.id.layout_my_performance)
                val image = view.findViewById<ConstraintLayout>(R.id.layout_images)
                set_image = view.findViewById<ImageView>(R.id.image_3)
               val lanuage_setting=view.findViewById<ConstraintLayout>(R.id.layout_language_settings)
               val your_service=view.findViewById<ConstraintLayout>(R.id.layout_your_services)
               val vechile_details=view.findViewById<ConstraintLayout>(R.id.layout_vehicle_details)


                var set_image= getArguments()?.getString("uri");


                lanuage_setting.setOnClickListener {

                    Navigation.findNavController(view).navigate(R.id.language_Settings_Fragment)

                }



                image.setOnClickListener {
//           val takePictureIntent =  Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(takePictureIntent, REQUEST_CODE)


                   // Navigation.findNavController(view).navigate(R.id.selfi_Fragment)


                    openBottomSheet();

                }


                handover_id_card.setOnClickListener {
                    Navigation.findNavController(view).navigate(R.id.handover_Listing_Fragment)

                }



                vechile_details.setOnClickListener {

                    val dialog = BottomSheetDialog(requireActivity())
                    val view = layoutInflater.inflate(R.layout.order_accept_bottomsheet, null)

                    dialog.setCancelable(true)
                    dialog.setContentView(view)
                    dialog.show()

                }

               your_service.setOnClickListener {

                   val dialog = BottomSheetDialog(requireActivity())
                   val view = layoutInflater.inflate(R.layout.create_order_bottomsheet, null)

                   dialog.setCancelable(true)
                   dialog.setContentView(view)
                   dialog.show()


               }


                document_details.setOnClickListener {

                    Navigation.findNavController(view).navigate(R.id.accountFragment)
                }

//                rate_card.setOnClickListener {
//
//                    Navigation.findNavController(view).navigate(R.id.rate_Card_Fragment)
//
//                }


                guidelines.setOnClickListener {

                    Navigation.findNavController(view).navigate(R.id.guidelines_Fragment)

                }


//        image.setOnClickListener {
////            Toast.makeText(requireContext(),"this is toast message",Toast.LENGTH_SHORT).show()
//            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivity(cameraIntent)
//
//        }


                return view
            }

            private fun openBottomSheet() {
                val dialog = BottomSheetDialog(requireActivity())
                val view = layoutInflater.inflate(R.layout.bottomsheet_camera_gallery, null)
                val camera = view.findViewById<LinearLayout>(R.id.layout_camera)
                dialog.setCancelable(true)
                dialog.setContentView(view)
                dialog.show()



                camera!!.setOnClickListener {
                    val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(takePictureIntent, REQUEST_CODE)
                    dialog.dismiss()


                }


                val gallery = view.findViewById<LinearLayout>(R.id.layout_gallery)
                gallery.setOnClickListener {
                    val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    intent.type = "image/*"
                    startActivityForResult(intent, GALLERY_REQEST_CODE)
                    dialog.dismiss()

                }


            }


        }
