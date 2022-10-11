package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPrefences

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //escodendo barra
        supportActionBar?.hide()

        //instanciando a Function
        handleUserName()

        //eventos de click
        binding.btnFrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_frase) {
            var s = ""

        }else if(view.id == R.id.image_all){

        }else if(view.id == R.id.image_happy){

        }else if(view.id == R.id.image_sunny){

        }
    }

    //pegando o name que foi salvo na UserActivity
    private fun handleUserName() {
        val name = SecurityPrefences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"

    }

}