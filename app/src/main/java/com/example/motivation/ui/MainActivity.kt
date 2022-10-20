package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPrefences

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //escodendo barra
        supportActionBar?.hide()

        //instanciando a Function
        handleUserName() //busca o user name
        handleFilter(R.id.image_all) // começa o app aberto no all
        handleNextPhrase() //iniciando o app com uma frase qnd o app carrega a primeira vez

        //eventos de click
        binding.btnFrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    //Wifi de onclick :)
    override fun onClick(view: View) {
        if (view.id == R.id.btn_frase) {
           handleNextPhrase()

            //listando os botões que serão clicados e chamando a função que muda de cor
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            handleFilter(view.id)//passando id do elemento que foi clicado
        }
    }

    private fun handleNextPhrase(){
       val phrase = Mock().getPhrase(categoryId) //instaciando a classe e a categoria
        binding.frase.text = phrase //clicando no botão e fazendo a frase aparecer
    }

    //Mudando a cor dos itens apos clicar
    private fun handleFilter(id: Int) {
        //setando cor padrão
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.light_blue))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.light_blue))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.light_blue))

        //lógica para quando o botão for clicado
        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL //FILTRO PARA FRASES
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }


    //pegando o name que foi salvo na UserActivity
    private fun handleUserName() {
        val name = SecurityPrefences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"

    }

}