package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_empresa)

        findViewById<Button>(R.id.botao_cadastrar).setOnClickListener {
            startActivity(Intent(this, CadastroEmpresa::class.java))
        }
    }
}
