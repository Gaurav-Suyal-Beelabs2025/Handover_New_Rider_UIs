package com.suyal.handovernewrideruis
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navController = findNavController(R.id.activity_main_nav_host_fragment1)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_botton)
        bottomNavigationView.setupWithNavController(navController)



        navController.addOnDestinationChangedListener { _, destination, _ ->



            if (destination.id==R.id.handover_id_cardFragment){
                bottomNavigationView.visibility=View.GONE
            }



            else if (destination.id==R.id.rate_Card_Fragment){
                bottomNavigationView.visibility=View.GONE
            }

            else if (destination.id==R.id.guidelines_Fragment){
                bottomNavigationView.visibility=View.GONE
            }



            else{

                bottomNavigationView.visibility=View.VISIBLE
            }
        }
    }

}