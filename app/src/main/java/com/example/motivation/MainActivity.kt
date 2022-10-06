package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //escodendo barra
        supportActionBar?.hide()

        //eventos de click
        binding.btnFrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_frase){

            var s = ""


        }
    }
}
