package com.gestaofrotas

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_empresa)

        val botaoCadastrar: Button = findViewById(R.id.botao_cadastrar)
        botaoCadastrar.setOnClickListener {
            Toast.makeText(this, "Cadastro enviado com sucesso!", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
