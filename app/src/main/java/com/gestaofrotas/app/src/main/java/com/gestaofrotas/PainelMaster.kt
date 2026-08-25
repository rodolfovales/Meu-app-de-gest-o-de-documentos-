package com.gestaofrotas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PainelMaster : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.painel_master)

        findViewById<TextView>(R.id.titulo_master).text = "🔑 Painel Master — Todas as Empresas"
    }
}
