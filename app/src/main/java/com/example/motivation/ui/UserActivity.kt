package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPrefences
import com.example.motivation.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ESCONDENDO BARRA
        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

//        verifyUserName()

    }
    //VERIFICANDO SE O NOME DO USUÁRIO JA FOI DEFINIDO
//    private fun verifyUserName() {
//        val name = SecurityPrefences(this).getString(MotivationConstants.KEY.USER_NAME)
//        if(name != ""){
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
//
//    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()//metodo para salvar

        }
    }

    private fun handleSave() {

        val name = binding.editName.text.toString() //pegando o texto inserido no editText

        //validação de input vazio
        if (name != "") {

            //instanciando o sh preferences para salvar o nome
            SecurityPrefences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

            // indo para outra activity caso o nome esteja preenchido
            startActivity(Intent(this, MainActivity::class.java))
            finish() //vai destruir a tela, só vou poder ve-la reiniciando o app

        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()


        }

    }
}