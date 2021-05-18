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
        meuArrayPerfis.add(Pessoa("Bianca", "", "", "", "1122334455", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Celso", "", "", "", "22334455", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "55667788", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayBaba(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paulo", "", "", "", "88997744", R.drawable.ic_baseline_anchor_24))
        meuArrayPerfis.add(Pessoa("Cassio", "", "", "", "99887766", R.drawable.ic_baseline_anchor_24))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "66554433", R.drawable.ic_baseline_anchor_24))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    /*fun carregarArrayEletricista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Caio", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Amanda", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Jack", "", "", "", "", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayDiarista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paloma", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Thiego", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Luiza", "", "", "", "", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayCabelereiro(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Andrei", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Brenda", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Carol", "", "", "", "", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayManicure(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Luiz", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Julia", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Elena", "", "", "", "", R.drawable.ic_android_black_24dp))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }*/
}
