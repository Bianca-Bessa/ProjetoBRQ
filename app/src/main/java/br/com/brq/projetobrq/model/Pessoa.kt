package br.com.brq.projetobrq.model

import androidx.annotation.DrawableRes
import java.io.Serializable

class Pessoa(

        val nome: String,
        val endereco: String,
        @DrawableRes
        val foto: Int,
        val telefone: Int

) : Serializable


