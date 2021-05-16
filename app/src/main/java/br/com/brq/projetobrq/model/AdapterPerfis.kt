package br.com.brq.projetobrq.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.R

class AdapterPerfis (

    val context: Context,
    var listaDePerfis: ArrayList<Pessoa>,
    val onClick: ItemClickListener? = null

    ): RecyclerView.Adapter<ViewHolderPerfil>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPerfil {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_da_lista_de_perfis, parent, false)
        return ViewHolderPerfil(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolderPerfil, position: Int) {
        listaDePerfis[position].also {
            holder.textViewTitulo.text = "${it.nome}"
            holder.imageViewAvatar.setImageResource(it.photo)
        }

        holder.textViewTitulo.text
    }

    override fun getItemCount(): Int {
        return listaDePerfis.size
    }
}

class ViewHolderPerfil(itemView : View, private var onClick: ItemClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

    var textViewTitulo : TextView
    var imageViewAvatar: ImageView

    init {
        textViewTitulo = itemView.findViewById(R.id.txtView_titulo)
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)

        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        onClick?.onClickItem(v, adapterPosition)
    }
}

interface ItemClickListener{
    fun onClickItem(view: View?, index: Int)
}