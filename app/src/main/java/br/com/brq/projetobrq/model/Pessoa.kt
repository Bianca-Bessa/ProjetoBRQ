package br.com.brq.projetobrq.model


import androidx.annotation.DrawableRes

open class Pessoa (

        open val nome: String,
        open val endereco: String,
        open val bairro: String,
        open val cidade: String,

        open val telefone: String,
        open val detalhe: String,
        @DrawableRes
        open val photo: Int

){
}