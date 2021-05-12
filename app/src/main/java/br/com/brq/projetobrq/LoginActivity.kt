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

        carregarElementos()
        carregarEventos()
    }

    fun carregarElementos(){
        editTextEmail = findViewById(R.id.editText_email)
        editTextSenha = findViewById(R.id.editText_senha)
        botaoLogin = findViewById(R.id.button)
        botaoLogin.setOnClickListener { abrirCardView() }
        textView = findViewById(R.id.textView_esqueceuSenha)
        textView = findViewById(R.id.textView_naoTemConta)
    }

    fun carregarEventos(){

        editTextEmail.setOnClickListener() {
            val email = editTextEmail.text.toString()
            val senha = editTextSenha.text.toString()

            val usuario = Usuario(email = email, senha = senha)

            if(usuario.validarEmail()){
                println("EMAIL SUCESSO!!!")
            }else{
                println("EMAIL INVÁLIDO!!!")
            }

            if (usuario.validarSenha()){
                println("SENHA SUCESSO!!!")
            }else{
                println("SENHA INVÁLIDA")
            }
        }

    }

    fun abrirCardView(){
        val intent = Intent(this, CardViewActivity::class.java)
        startActivity(intent)
    }
}