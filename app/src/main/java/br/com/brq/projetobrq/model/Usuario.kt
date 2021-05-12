package br.com.brq.projetobrq.model

class Usuario(

        val email: String,
        val senha: String
        //val profissao: String

) {
    fun validarEmail() : Boolean{
        return email != ""
    }

    fun validarSenha() : Boolean{
        return senha != "" && email.length >=6
    }

    override fun toString(): String {
        return super.toString()
    }
}