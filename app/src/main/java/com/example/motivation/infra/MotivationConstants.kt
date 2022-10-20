package com.example.motivation.infra

//criando uma const para o nome da key
class MotivationConstants private constructor(){//private constructor para não ter como instanciar

    object KEY{
       const val USER_NAME = "USER_NAME"

    }

    object FILTER{
        const val ALL = 1
        const val HAPPY = 2
        const val SUNNY = 3
    }

}