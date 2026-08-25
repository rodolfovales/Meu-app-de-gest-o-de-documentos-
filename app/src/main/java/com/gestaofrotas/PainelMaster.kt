package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PainelMaster : AppCompatActivity() {

    // Lista de empresas cadastradas (depois vamos ligar ao banco de dados)
    private val empresas = mutableListOf(
        Empresa("00.000.000/0001-00", "Empresa Exemplo LTDA", "João da Silva", "(61) 99999-0000", "contato@exemplo.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.painel_master)

        atualizarLista()
    }

    private fun atualizarLista() {
        val lista = findViewById<ListView>(R.id.lista_empresas)
        val adaptador = AdaptadorEmpresa()
        lista.adapter = adaptador

        lista.onItemClickListener = { _, _, posicao, _ ->
            val emp = empresas[posicao]
            val intent = Intent(this, DetalhesEmpresa::class.java)
            intent.putExtra("cnpj", emp.cnpj)
            intent.putExtra("razao", emp.razaoSocial)
            startActivity(intent)
        }
    }

    inner class AdaptadorEmpresa : BaseAdapter() {
        override fun getCount() = empresas.size
        override fun getItem(pos: Int) = empresas[pos]
        override fun getItemId(pos: Int) = pos.toLong()

        override fun getView(pos: Int, view: View?, pai: ViewGroup?): View {
            val v = view ?: LayoutInflater.from(this@PainelMaster)
                .inflate(R.layout.item_empresa, pai, false)

            val emp = getItem(pos)
            v.findViewById<TextView>(R.id.item_nome).text = emp.razaoSocial
            v.findViewById<TextView>(R.id.item_cnpj).text = "CNPJ: ${emp.cnpj}"
            v.findViewById<TextView>(R.id.item_status).text = "📄 5 documentos"

            return v
        }
    }
}
