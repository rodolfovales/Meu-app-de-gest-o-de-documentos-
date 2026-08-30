package com.gestaofrotas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PainelMaster : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EmpresaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.painel_master)

        recyclerView = findViewById(R.id.recycler_empresas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = EmpresaAdapter(ListaEmpresas.listar()) { empresa ->
            abrirDetalhes(empresa)
        }
        recyclerView.adapter = adapter

        atualizarLista()
    }

    override fun onResume() {
        super.onResume()
        atualizarLista()
    }

    private fun atualizarLista() {
        adapter.atualizar(ListaEmpresas.listar())

        val titulo = findViewById<TextView>(R.id.titulo_master)
        titulo.text = "Painel Master - ${ListaEmpresas.listar().size} empresa(s) recebida(s)"
    }

    private fun abrirDetalhes(empresa: Empresa) {
        val intent = Intent(this, DetalhesEmpresa::class.java).apply {
            putExtra("cnpj", empresa.cnpj)
            putExtra("razao", empresa.razaoSocial)
            putExtra("cnpj_arquivo", empresa.arquivoCnpj?.toString())
            putExtra("contrato_arquivo", empresa.arquivoContratoSocial?.toString())
            putExtra("socios_arquivo", empresa.arquivoSocios?.toString())
            putExtra("endereco_arquivo", empresa.arquivoEndereco?.toString())
            putExtra("faturamento_arquivo", empresa.arquivoFaturamento?.toString())
        }
        startActivity(intent)
    }
}

// Adaptador para mostrar a lista
class EmpresaAdapter(
    private var lista: List<Empresa>,
    private val aoClicar: (Empresa) -> Unit
) : RecyclerView.Adapter<EmpresaAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtRazao: TextView = view.findViewById(R.id.txt_razao)
        val txtCnpj: TextView = view.findViewById(R.id.txt_cnpj)
        val btnVer: Button = view.findViewById(R.id.btn_ver)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_empresa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emp = lista[position]
        holder.txtRazao.text = emp.razaoSocial
        holder.txtCnpj.text = "CNPJ: ${emp.cnpj}"
        holder.btnVer.setOnClickListener { aoClicar(emp) }
    }

    override fun getItemCount() = lista.size

    fun atualizar(novaLista: List<Empresa>) {
        lista = novaLista
        notifyDataSetChanged()
    }
}
