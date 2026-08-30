package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaSenhaMaster : AppCompatActivity() {

    // 🔒 SENHA DO MASTER — ALTERE AQUI SE QUISER!
    private val SENHA_CORRETA = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_senha_master)

        val campoSenha = findViewById<EditText>(R.id.campo_senha)
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        btnEntrar.setOnClickListener {
            val senhaDigitada = campoSenha.text.toString()

            when {
                senhaDigitada.isBlank() -> {
                    Toast.makeText(this, "⚠️ Digite a senha!", Toast.LENGTH_SHORT).show()
                }
                senhaDigitada == SENHA_CORRETA -> {
                    Toast.makeText(this, "✅ Acesso liberado!", Toast.LENGTH_SHORT).show()
                    val irParaMaster = Intent(this, PainelMaster::class.java)
                    startActivity(irParaMaster)
                    finish()
                }
                else -> {
                    Toast.makeText(this, "❌ Senha incorreta! Tente novamente.", Toast.LENGTH_SHORT).show()
                    campoSenha.text.clear()
                }
            }
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}

