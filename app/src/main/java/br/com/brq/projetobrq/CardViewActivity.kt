package br.com.brq.projetobrq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.adapter.AdapterProdutoCardView
import br.com.brq.projetobrq.model.ProdutoCardView


class CardViewActivity : AppCompatActivity() {

    lateinit var listaComponente: RecyclerView
    lateinit var arrayDeProdutos: ArrayList<ProdutoCardView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_grid)

        arrayDeProdutos = ProdutoCardView.carregarListaMock()

        listaComponente = findViewById(R.id.nosso_recycler_view)
        listaComponente.layoutManager = GridLayoutManager(this, 2)
        listaComponente.adapter = AdapterProdutoCardView(arrayDeProdutos, this)
    }
}