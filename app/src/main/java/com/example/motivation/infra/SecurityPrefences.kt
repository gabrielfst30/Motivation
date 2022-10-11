package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPrefences (context: Context){

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    //método que salva string usando uma chave
    fun storeString(key: String, str: String) {
        security.edit().putString(key,str).apply()

    }

    //recuperando a string que é uma chave
    fun getString(key: String): String{
        return security.getString(key, "") ?: "" // se a string for nula, set null

    }


}