package br.com.brq.projetobrq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.brq.projetobrq.model.Usuario

class RegisterActivity : AppCompatActivity() {

    lateinit var editTextNome : EditText
    lateinit var editTextEndereco : EditText
    lateinit var editTextBairro : EditText
    lateinit var editTextCidade : EditText
    lateinit var editTextTelefone : EditText
    lateinit var editTextEmail : EditText
    lateinit var editTextSenha : EditText
    lateinit var editTextConfirmaSenha : EditText

    lateinit var btnCadastro : Button
    lateinit var btnCancelar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.title = "Cadastro"

        carregarElementos()
        carregarEventosClickCadastro()
        carregarEventoClickCancelar()
        carregarSpinner()
    }

    fun carregarSpinner(){
        val spinner: Spinner = findViewById(R.id.spinner_registro)
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun carregarElementos(){
        editTextNome = findViewById(R.id.editTextNome)
        editTextEndereco = findViewById(R.id.editTextEndereco)
        editTextBairro = findViewById(R.id.editTextBairro)
        editTextCidade = findViewById(R.id.editTextCidade)
        editTextTelefone = findViewById(R.id.editTextTelefone)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextSenha = findViewById(R.id.editTextSenha)
        editTextConfirmaSenha = findViewById(R.id.editTextConfirmaSenha)

        btnCadastro = findViewById(R.id.buttonCadastro)
        btnCancelar = findViewById(R.id.buttonCancelar)
    }

    fun carregarEventosClickCadastro(){
        btnCadastro.setOnClickListener {

            val nome = editTextNome.text.toString()
            val endereco = editTextEndereco.text.toString()
            val bairro = editTextBairro.text.toString()
            val cidade = editTextCidade.text.toString()
            val telefone = editTextTelefone.text.toString()
            val email = editTextEmail.text.toString()
            val senha = editTextSenha.text.toString()
            val confirmaSenha = editTextConfirmaSenha.text.toString()

            var flagValidacao = false
            val user = Usuario(nome = nome, endereco = endereco, bairro = bairro, cidade = cidade, telefone = telefone, email = email, senha = senha, confirmaSenha = confirmaSenha, detalhe = "", photo = 0)

            if (user.validarNome()){
                if (user.validarTelefone()){
                    if (user.validarEmail()){
                        if (user.validarSenha()){
                            if(senha == confirmaSenha) {
                                Toast.makeText(this, "Confirme a senha", Toast.LENGTH_LONG).show()
                                flagValidacao = true
                            }
                        }
                        else{
                            Toast.makeText(this, "Senha obrigatoria", Toast.LENGTH_LONG).show()
                        }
                    }
                    else{
                        Toast.makeText(this, "E-mail obrigatorio", Toast.LENGTH_LONG).show()
                    }
                }
                else{
                    Toast.makeText(this, "Telefone obrigatorio", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "Nome obrigatorio", Toast.LENGTH_LONG).show()
            }

            if(flagValidacao){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun carregarEventoClickCancelar(){
        btnCancelar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}