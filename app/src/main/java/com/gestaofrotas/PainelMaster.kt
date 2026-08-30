package com.gestaofrotas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PainelMaster : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.painel_master)

        val tituloMaster: TextView = findViewById(R.id.titulo_master)
        tituloMaster.text = "Painel Master - Documentos Recebidos"
    }
}

