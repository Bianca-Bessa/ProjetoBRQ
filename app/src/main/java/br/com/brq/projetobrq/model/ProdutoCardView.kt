package br.com.brq.projetobrq.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import br.com.brq.projetobrq.R

class ProdutoCardView(
    val nome: String,
    @DrawableRes
    val imagem: Int
) {

    companion object {

        fun carregarListaMock(): ArrayList<ProdutoCardView> {
            val lista = arrayListOf<ProdutoCardView>()

            lista.add(ProdutoCardView("Babá", R.drawable.ic_chupeta))
            lista.add(ProdutoCardView("Eletricista", R.drawable.ic_raio))
            lista.add(ProdutoCardView("Diarista", R.drawable.ic_broom))
            lista.add(ProdutoCardView("Encanador", R.drawable.ic_faucet))
            lista.add(ProdutoCardView("Cabelereiro", R.drawable.ic_secador_de_cabelo))
            lista.add(ProdutoCardView("Manicure", R.drawable.ic_nail_polish))
            return lista
        }

    }
}