package br.com.brq.projetobrq.adapter.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.R

class ViewHolderItemProduto(view: View) : RecyclerView.ViewHolder(view) {

    var textoProfissao: TextView
    var imagemProfissao: ImageView

    init {

        textoProfissao = itemView.findViewById(R.id.textViewProfissao)
        imagemProfissao = itemView.findViewById(R.id.imageViewProfissao)
    }
}