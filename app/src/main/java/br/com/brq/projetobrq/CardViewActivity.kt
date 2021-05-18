package br.com.brq.projetobrq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.adapter.AdapterProdutoCardView
import br.com.brq.projetobrq.adapter.OnItemCardClick
import br.com.brq.projetobrq.model.ProdutoCardView
import br.com.brq.projetobrq.model.Profissao


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

        when (produtoCardView.profissao) {
            Profissao.BABA -> startActivity(Intent(this, SplashActivity::class.java))
            Profissao.ELETRICISTA -> startActivity(Intent(this, SplashActivity::class.java))
            Profissao.DIARISTA -> startActivity(Intent(this, SplashActivity::class.java))
            Profissao.ENCANADOR -> startActivity(Intent(this, SplashActivity::class.java))
            Profissao.CABELEREIRO -> startActivity(Intent(this, SplashActivity::class.java))
            Profissao.MANICURE -> startActivity(Intent(this, SplashActivity::class.java))
        }
    }
}