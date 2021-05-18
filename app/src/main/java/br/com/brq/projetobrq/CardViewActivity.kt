package br.com.brq.projetobrq


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class CardViewActivity : AppCompatActivity() {

    lateinit var btnEncanador: Button
    lateinit var btnBaba: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        carregarEventos()
        eventosClick()

    }

    fun carregarEventos() {
        btnEncanador = findViewById(R.id.btn_encanador)
        btnBaba = findViewById(R.id.btn_baba)
    }

    fun eventosClick() {
        btnEncanador.setOnClickListener {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            //Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 1)
            intent.putExtras(params)

            startActivity(intent)
        }

        btnBaba.setOnClickListener {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            //Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 2)
            intent.putExtras(params)

            startActivity(intent)
        }
    }
}