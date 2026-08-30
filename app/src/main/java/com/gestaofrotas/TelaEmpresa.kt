package com.gestaofrotas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.tela_empresa.*

class TelaEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_empresa)

        botao_cadastrar.setOnClickListener {
            Toast.makeText(this, "Cadastro enviado com sucesso!", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
