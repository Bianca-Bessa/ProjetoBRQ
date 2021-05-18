package br.com.brq.projetobrq

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
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
        carregarArrayBaba()

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
            //tel = findViewById(R.id.tel)
            var flagTel = true
            //tel.setOnClickListener
                if (ActivityCompat.checkSelfPermission( this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "11988962650"))
                    startActivity(intent)
                }else{
                    ActivityCompat.requestPermissions(this,
                            arrayOf(Manifest.permission.CALL_PHONE), 1)

                }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String?>,
            grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "11988962650"))
                    startActivity(intent)
                }
            }
        }
    }


    fun carregarArrayEncanador(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Bianca", "", "", "", "", "Encanador", R.drawable.ic_faucet))
        meuArrayPerfis.add(Pessoa("Celso", "", "", "", "", "Encanador", R.drawable.ic_faucet))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "", "Encanador", R.drawable.ic_faucet))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayBaba(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paulo", "", "", "", "", "Babá", R.drawable.ic_chupeta))
        meuArrayPerfis.add(Pessoa("Cassio", "", "", "", "", "Babá", R.drawable.ic_chupeta))
        meuArrayPerfis.add(Pessoa("Pamela", "", "", "", "", "Babá", R.drawable.ic_chupeta))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayEletricista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Caio", "", "", "", "", "Eletricista", R.drawable.ic_raio))
        meuArrayPerfis.add(Pessoa("Amanda", "", "", "", "", "Eletricista", R.drawable.ic_raio))
        meuArrayPerfis.add(Pessoa("Jack", "", "", "", "", "Eletricista", R.drawable.ic_raio))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayDiarista(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Paloma", "", "", "", "", "Diarista", R.drawable.ic_broom))
        meuArrayPerfis.add(Pessoa("Thiego", "", "", "", "", "Diarista", R.drawable.ic_broom))
        meuArrayPerfis.add(Pessoa("Luiza", "", "", "", "", "Diarista", R.drawable.ic_broom))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayCabelereiro(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Andrei", "", "", "", "", "Cabelereiro", R.drawable.ic_secador_de_cabelo))
        meuArrayPerfis.add(Pessoa("Brenda", "", "", "", "", "Cabelereiro", R.drawable.ic_secador_de_cabelo))
        meuArrayPerfis.add(Pessoa("Carol", "", "", "", "", "Cabelereiro", R.drawable.ic_secador_de_cabelo))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }

    fun carregarArrayManicure(){
        meuArrayPerfis = ArrayList()
        meuArrayPerfis.add(Pessoa("Luiz", "", "", "", "", "Manicure", R.drawable.ic_nail_polish))
        meuArrayPerfis.add(Pessoa("Julia", "", "", "", "", "Manicure", R.drawable.ic_nail_polish))
        meuArrayPerfis.add(Pessoa("Elena", "", "", "", "", "Manicure", R.drawable.ic_nail_polish))

        listaBase = arrayListOf()
        listaBase.addAll(meuArrayPerfis)
    }
}
