package br.com.brq.projetobrq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.model.AdapterPerfis
import br.com.brq.projetobrq.model.ItemClickListener
import br.com.brq.projetobrq.model.Pessoa
import java.util.Locale.filter

class PerfisTrabalhadoresActivity : AppCompatActivity(), ItemClickListener {

    var recyclerView: RecyclerView? = null
    lateinit var meuArrayPerfis: ArrayList<Pessoa>
    lateinit var listaBase: ArrayList<Pessoa>
    lateinit var editTextFilter: EditText
    lateinit var adapter: AdapterPerfis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfis_trabalhadores)

        var params = intent.extras
        var flag = params?.getInt("flag")
        if (flag == 1){
            carregarArrayEncanador()
        }
        if (flag == 2){
            carregarArrayBaba()
        }

        carregarElementos()
        carregarFilter()

        AdapterPerfis(this, meuArrayPerfis, this).let {
            adapter = it
            recyclerView?.adapter = it
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun carregarElementos(){
        recyclerView = findViewById(R.id.rv_perfil)
        editTextFilter = findViewById(R.id.editText_pesquisa)
    }

    fun carregarFilter(){
        editTextFilter.addTextChangedListener (object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                var filtrar = s.toString()
                if (!filtrar.isNullOrEmpty()) {
                    val filterLista = meuArrayPerfis.filter {
                        //it.nome.equals(filtrar,true)
                        it.nome.contains(filtrar, true)
                    }

                    val listaFiltrada = arrayListOf<Pessoa>()

                    filterLista.forEach {
                        listaFiltrada.add(it)
                    }

                    adapter.update(listaFiltrada)
                }

                else{
                    adapter.update(listaBase)
                }
            }
        })
    }

    override fun onClickItem(view: View?, index: Int) {
        Toast.makeText(this, meuArrayPerfis[index].nome, Toast.LENGTH_LONG).show()

        //val intent = Intent(this, LoginActivity::class.java)
        //startActivity(intent)
    }

    fun carregarArrayEncanador(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Bianca", "", "", "", "", "Encanador", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Celso", "", "", "", "", "Encanador", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "", "Encanador", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayBaba(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paulo", "", "", "", "", "Babá", R.drawable.ic_baseline_anchor_24))
        meuArrayPerfis.add(Pessoa("Cassio", "", "", "", "", "Babá", R.drawable.ic_baseline_anchor_24))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "", "Babá", R.drawable.ic_baseline_anchor_24))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    /*fun carregarArrayEletricista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Caio", "", "", "", "", "Eletricista", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Amanda", "", "", "", "", "Eletricista", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Jack", "", "", "", "", "Eletricista", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayDiarista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paloma", "", "", "", "", "Diarista", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Thiego", "", "", "", "", "Diarista", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Luiza", "", "", "", "", "Diarista", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayCabelereiro(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Andrei", "", "", "", "", "Cabelereiro", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Brenda", "", "", "", "", "Cabelereiro", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Carol", "", "", "", "", "Cabelereiro", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayManicure(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Luiz", "", "", "", "", "Manicure", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Julia", "", "", "", "", "Manicure", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Elena", "", "", "", "", "Manicure", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }*/
}
