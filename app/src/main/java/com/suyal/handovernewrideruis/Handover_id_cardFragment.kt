package com.suyal.handovernewrideruis

import android.app.Activity
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class Handover_id_cardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(com.suyal.handovernewrideruis.R.layout.fragment_handover_id_card, container, false)


         val arrow_back=view.findViewById<ImageView>(com.suyal.handovernewrideruis.R.id.ic_arrow_back)
         val download_pdf=view.findViewById<TextView>(com.suyal.handovernewrideruis.R.id.txt_view_declaration)


           arrow_back.setOnClickListener {

               Navigation.findNavController(view).navigate(com.suyal.handovernewrideruis.R.id.profile_Fragment)

           }

        download_pdf.setOnClickListener {

            convertXmlToPdf()

        }

    return view
    }

    fun convertXmlToPdf() {
        // Inflate the XML layout file
        try {

            val view: View = LayoutInflater.from(requireContext())
                .inflate(com.suyal.handovernewrideruis.R.layout.pdf_layout, null)
            val displayMetrics = DisplayMetrics()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                requireContext().getDisplay()!!.getRealMetrics(displayMetrics)
            } else (context as Activity?)!!.windowManager.getDefaultDisplay()
                .getMetrics(displayMetrics)
            view.measure(
                View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.widthPixels,
                    View.MeasureSpec.EXACTLY
                ),
                View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.heightPixels,
                    View.MeasureSpec.EXACTLY
                )
            )
            Log.d("mylog", "Width Now " + view.measuredWidth)
            view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
            // Create a new PdfDocument instance
            val document = PdfDocument()

            // Obtain the width and height of the view
            val viewWidth = view.measuredWidth
            val viewHeight = view.measuredHeight
            // Create a PageInfo object specifying the page attributes
            val pageInfo = PageInfo.Builder(viewWidth, viewHeight, 1).create()

            // Start a new page
            val page = document.startPage(pageInfo)

            // Get the Canvas object to draw on the page
            val canvas: Canvas = page.canvas

            // Create a Paint object for styling the view
            val paint = Paint()
            paint.setColor(Color.WHITE)

            // Draw the view on the canvas
            view.draw(canvas)

            // Finish the page
            document.finishPage(page)

            // Specify the path and filename of the output PDF file
            val downloadsDir: File =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val fileName = "Rajeev_Ranjan_Handover_ID_CARD.pdf"
            val filePath = File(downloadsDir, fileName)
            try {
                // Save the document to a file
                val fos = FileOutputStream(filePath)
                document.writeTo(fos)
                document.close()
                fos.close()
                // PDF conversion successful

                Toast.makeText(
                    requireContext(),
                    "XML to PDF Conversion Successful",
                    Toast.LENGTH_SHORT
                ).show()
                //Toast.makeText(this, "XML to PDF Conversion Successful", Toast.LENGTH_LONG).show()
            } catch (e: IOException) {
                e.printStackTrace()
                // Error occurred while converting to PDF
            }
        }
        catch (e:Exception)
        {
            Log.d("TAG",e.message.toString())
        }
    }


   }