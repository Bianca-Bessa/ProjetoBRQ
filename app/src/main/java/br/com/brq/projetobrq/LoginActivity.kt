package br.com.brq.projetobrq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.brq.projetobrq.model.Usuario

class LoginActivity : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextSenha: EditText
    lateinit var botaoLogin: Button
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = "Login"

        carregarElementos()
        carregarEventos()
        carregarClickTextView()
    }

    fun carregarElementos(){
        editTextEmail = findViewById(R.id.editText_email)
        editTextSenha = findViewById(R.id.editText_senha)
        botaoLogin = findViewById(R.id.button)
        //botaoLogin.setOnClickListener { abrirCardView() }
        textView = findViewById(R.id.textView_naoTemConta)
    }

    fun carregarEventos(){

        botaoLogin.setOnClickListener() {
            val email = editTextEmail.text.toString()
            val senha = editTextSenha.text.toString()

            var flagValidacao = false
            var usuario = Usuario(nome = "", endereco = "", bairro = "", cidade = "", telefone = "", email = email, senha = senha, confirmaSenha = "", photo = 0)

            if(usuario.validarEmail()){
                if (usuario.validarSenha()){
                    flagValidacao = true
                }
                else{
                    println("SENHA INVÁLIDA")
                }
            }
            else{
                println("EMAIL INVÁLIDO!!!")
            }
            if(flagValidacao){
                val intent = Intent(this, CardViewActivity::class.java)
                startActivity(intent)
            }
        }

    }

    /*fun abrirCardView(){
        val intent = Intent(this, CardViewActivity::class.java)
        startActivity(intent)
    }*/

    fun carregarClickTextView(){
        textView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}