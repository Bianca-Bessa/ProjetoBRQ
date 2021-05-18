package br.com.brq.projetobrq.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import br.com.brq.projetobrq.R
import br.com.brq.projetobrq.model.Profissao.*

class ProdutoCardView(
    val profissao: Profissao,
    val nome: String,
    @DrawableRes
    val imagem: Int
) {

    companion object {

        fun carregarListaMock(): ArrayList<ProdutoCardView> {
            val lista = arrayListOf<ProdutoCardView>()

            lista.add(criarItemLista(BABA))
            lista.add(criarItemLista(ELETRICISTA))
            lista.add(criarItemLista(DIARISTA))
            lista.add(criarItemLista(ENCANADOR))
            lista.add(criarItemLista(CABELEREIRO))
            lista.add(criarItemLista(MANICURE))
            return lista
        }

        private fun criarItemLista (profissao: Profissao): ProdutoCardView{
            return when (profissao) {
                BABA -> ProdutoCardView(profissao = BABA, nome = "Babá", imagem = R.drawable.ic_chupeta)
                ELETRICISTA -> ProdutoCardView(profissao = ELETRICISTA, nome = "Eletricista", imagem = R.drawable.ic_raio)
                DIARISTA -> ProdutoCardView(profissao = DIARISTA, nome ="Diarista", imagem = R.drawable.ic_broom)
                ENCANADOR -> ProdutoCardView(profissao = ENCANADOR, nome =  "Encanador", imagem = R.drawable.ic_faucet)
                CABELEREIRO -> ProdutoCardView(profissao = CABELEREIRO, nome = "Cabelereiro", imagem = R.drawable.ic_secador_de_cabelo)
                MANICURE -> ProdutoCardView(profissao = MANICURE, nome = "Manicure", imagem = R.drawable.ic_nail_polish)

            }
        }
    }
}

enum class Profissao{
    BABA,
    ELETRICISTA,
    DIARISTA,
    ENCANADOR,
    CABELEREIRO,
    MANICURE
}