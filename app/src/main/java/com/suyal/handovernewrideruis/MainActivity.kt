package com.suyal.handovernewrideruis

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.suyal.handovernewrideruis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}