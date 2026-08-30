package com.gestaofrotas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalhesEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhes_empresa)

        findViewById<TextView>(R.id.detalhe_razao).text = intent.getStringExtra("razao") ?: ""
        findViewById<TextView>(R.id.detalhe_cnpj).text = "CNPJ: ${intent.getStringExtra("cnpj")}"

        fun abrirArquivo(uriStr: String?) {
            uriStr?.let {
                val uri = Uri.parse(it)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.ver_cnpj).setOnClickListener { abrirArquivo(intent.getStringExtra("cnpj_arquivo")) }
        findViewById<Button>(R.id.ver_contrato).setOnClickListener { abrirArquivo(intent.getStringExtra("contrato_arquivo")) }
        findViewById<Button>(R.id.ver_socios).setOnClickListener { abrirArquivo(intent.getStringExtra("socios_arquivo")) }
        findViewById<Button>(R.id.ver_endereco).setOnClickListener { abrirArquivo(intent.getStringExtra("endereco_arquivo")) }
        findViewById<Button>(R.id.ver_faturamento).setOnClickListener { abrirArquivo(intent.getStringExtra("faturamento_arquivo")) }
    }
}
