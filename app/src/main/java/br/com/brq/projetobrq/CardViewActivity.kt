package br.com.brq.projetobrq


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.adapter.AdapterProdutoCardView
import br.com.brq.projetobrq.adapter.OnItemCardClick
import br.com.brq.projetobrq.model.ProdutoCardView


class CardViewActivity : AppCompatActivity(), OnItemCardClick {

    lateinit var listaComponente: RecyclerView
    lateinit var arrayDeProdutos: ArrayList<ProdutoCardView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_grid)

        arrayDeProdutos = ProdutoCardView.carregarListaMock()

        listaComponente = findViewById(R.id.nosso_recycler_view)
        listaComponente.layoutManager = GridLayoutManager(this, 2)

        listaComponente.adapter = AdapterProdutoCardView(arrayDeProdutos, this, this)
    }

    override fun onItemCardClick(view: View, position: Int) {
        val produtoCardView = arrayDeProdutos[position]

        if (produtoCardView.nome == "Babá") {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            Toast.makeText(this, "Babá", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 1)
            intent.putExtras(params)

            startActivity(intent)
        }
        else if (produtoCardView.nome == "Eletricista") {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            Toast.makeText(this, "Eletricista", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 2)
            intent.putExtras(params)

            startActivity(intent)
        }

        else if (produtoCardView.nome == "Diarista") {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            Toast.makeText(this, "Diarista", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 3)
            intent.putExtras(params)

            startActivity(intent)
        }

        else if (produtoCardView.nome == "Encanador") {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            Toast.makeText(this, "Encanador", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 4)
            intent.putExtras(params)

            startActivity(intent)
        }

        else if (produtoCardView.nome == "Cabelereiro") {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            Toast.makeText(this, "Cabelereiro", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 5)
            intent.putExtras(params)

            startActivity(intent)
        }

        else if (produtoCardView.nome == "Manicure") {
            val intent = Intent(this, PerfisTrabalhadoresActivity::class.java)
            Toast.makeText(this, "Manicure", Toast.LENGTH_SHORT).show()

            val params = Bundle()
            params.putInt("flag", 6)
            intent.putExtras(params)

            startActivity(intent)
        }
    }
}