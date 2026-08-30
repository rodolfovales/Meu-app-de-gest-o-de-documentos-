package com.gestaofrotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.painel_master.*

class PainelMaster : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.painel_master)

        titulo_master.text = "Painel Master - Documentos Recebidos"
    }
}
