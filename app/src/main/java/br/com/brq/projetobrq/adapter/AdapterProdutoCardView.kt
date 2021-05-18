package br.com.brq.projetobrq.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.R
import br.com.brq.projetobrq.adapter.viewHolder.ViewHolderItemProduto
import br.com.brq.projetobrq.model.ProdutoCardView

class AdapterProdutoCardView(private val arrayDeProdutos: ArrayList<ProdutoCardView>, 
                             private val context: Context,
                            private val onClick: OnItemCardClick) :
        RecyclerView.Adapter<ViewHolderItemProduto>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemProduto {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_card_view, parent, false)
        return ViewHolderItemProduto(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolderItemProduto, position: Int) {
        arrayDeProdutos[position].apply {
            holder.textoProfissao.text = this.nome.toString()
            holder.imagemProfissao.setImageResource(this.imagem)
        }
    }

    override fun getItemCount(): Int {
        return arrayDeProdutos.size
    }

}

interface OnItemCardClick {

    fun onItemCardClick(view: View, position: Int)

}