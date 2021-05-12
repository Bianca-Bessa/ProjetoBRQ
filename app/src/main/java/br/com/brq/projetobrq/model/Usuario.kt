package br.com.brq.projetobrq.model

class Usuario(

    override val nome: String,
    override val endereco: String,
    override val bairro: String,
    override val cidade: String,
    override val telefone: String,
    val email: String,
    val senha: String,
    val confirmaSenha: String

) : Pessoa(nome, endereco, bairro, cidade, telefone) {

    fun validarNome(): Boolean{
        println("valor nome:" + nome)
        return nome != ""
    }

    fun validarTelefone(): Boolean{
        println("valor tel:" + telefone)
        return telefone != ""
    }

    fun validarEmail(): Boolean{
        println("valor email:" + email)
        return email != ""
    }

    fun validarSenha() : Boolean{
        return senha != "" && email.length >=6
    }

    fun validarConfimaSenha(): Boolean{
        println("valor senha:" + senha)
        return confirmaSenha != ""
    }

    override fun toString(): String {
        return super.toString()
    }
}