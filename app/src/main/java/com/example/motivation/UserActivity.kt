package com.example.motivation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //escodendo barra
        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()//metodo para salvar

        }

    }

    private fun handleSave() {
        val name = binding.editName.text.toString() //pegando o texto inserido no editText

        //validação de input vazio
        if (name != "") {

            // indo para outra activity caso o nome esteja preenchido
            startActivity(Intent(this, MainActivity::class.java))
            finish() //vai destruir a tela, só vou poder ve-la reiniciando o app

        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()


        }

    }
}