package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaLogin : AppCompatActivity() {

    // Usuário MASTER = VOCÊ
    private val masterEmail = "seu-email@exemplo.com"
    private val masterSenha = "sua-senha-aqui" // Altere para uma senha forte!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)

        val campoEmail = findViewById<EditText>(R.id.campo_email)
        val campoSenha = findViewById<EditText>(R.id.campo_senha)
        val botaoEntrar = findViewById<Button>(R.id.botao_entrar)

        botaoEntrar.setOnClickListener {
            val email = campoEmail.text.toString().trim()
            val senha = campoSenha.text.toString().trim()

            when {
                email == masterEmail && senha == masterSenha -> {
                    Toast.makeText(this, "Bem-vindo, Master!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, PainelMaster::class.java)
                    startActivity(intent)
                    finish()
                }
                email.isNotEmpty() && senha.isNotEmpty() -> {
                    Toast.makeText(this, "Acesso Empresa — validando...", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, TelaEmpresa::class.java)
                    intent.putExtra("cnpjUsuario", email)
                    startActivity(intent)
                    finish()
                }
                else -> {
                    Toast.makeText(this, "Preencha e-mail e senha!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
