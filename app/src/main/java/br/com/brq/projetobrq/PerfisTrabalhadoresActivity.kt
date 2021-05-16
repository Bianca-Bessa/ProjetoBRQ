package br.com.brq.projetobrq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brq.projetobrq.model.AdapterPerfis
import br.com.brq.projetobrq.model.ItemClickListener
import br.com.brq.projetobrq.model.Pessoa

class PerfisTrabalhadoresActivity : AppCompatActivity(), ItemClickListener {

    var recyclerView: RecyclerView? = null
    lateinit var meuArrayPerfis: ArrayList<Pessoa>
    lateinit var editTextFilter: EditText

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

        AdapterPerfis(this, meuArrayPerfis, this).let {
            recyclerView?.adapter = it
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    /*fun carregarFilter(){
        editTextFilter?.addTextChangedListener (object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {


            }

        })
    }*/

    fun carregarElementos(){
        recyclerView = findViewById(R.id.rv_perfil)
        editTextFilter = findViewById(R.id.editText_pesquisa)
    }

    fun carregarArrayEncanador(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Bianca", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Julio", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "", R.drawable.ic_android_black_24dp))
    }

    fun carregarArrayBaba(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paulo", "", "", "", "", R.drawable.ic_baseline_anchor_24))
        meuArrayPerfis.add(Pessoa("Cassio", "", "", "", "", R.drawable.ic_baseline_anchor_24))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "", R.drawable.ic_baseline_anchor_24))
    }

    fun carregarArrayEletricista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Caio", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Amanda", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Jack", "", "", "", "", R.drawable.ic_android_black_24dp))
    }

    fun carregarArrayDiarista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paloma", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Thiego", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Luiza", "", "", "", "", R.drawable.ic_android_black_24dp))
    }

    fun carregarArrayCabelereiro(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Andrei", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Brenda", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Carol", "", "", "", "", R.drawable.ic_android_black_24dp))
    }

    fun carregarArrayManicure(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Luiz", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Julia", "", "", "", "", R.drawable.ic_android_black_24dp))
        meuArrayPerfis.add(Pessoa("Elena", "", "", "", "", R.drawable.ic_android_black_24dp))
    }

    override fun onClickItem(view: View?, index: Int) {
        Toast.makeText(this, meuArrayPerfis[index].nome, Toast.LENGTH_LONG).show()

        //val intent = Intent(this, LoginActivity::class.java)
        //startActivity(intent)
    }
}