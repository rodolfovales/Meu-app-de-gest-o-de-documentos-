package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)

        val btnEmpresa: Button = findViewById(R.id.btn_empresa)
        val btnMaster: Button = findViewById(R.id.btn_master)

        btnEmpresa.setOnClickListener {
            val irParaEmpresa = Intent(this, TelaEmpresa::class.java)
            startActivity(irParaEmpresa)
        }

        btnMaster.setOnClickListener {
            val irParaSenha = Intent(this, TelaSenhaMaster::class.java)
            startActivity(irParaSenha)
        }
    }
}
