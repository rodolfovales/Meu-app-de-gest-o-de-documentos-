package com.gestaofrotas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_empresa)

        val cnpj = intent.getStringExtra("cnpjUsuario") ?: ""
        findViewById<TextView>(R.id.titulo_empresa).text = "🏢 Área da Empresa — CNPJ: $cnpj"
    }
}
