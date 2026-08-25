package com.gestaofrotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_empresa)

        val campoCNPJ = findViewById<EditText>(R.id.campo_cnpj)
        val campoRazao = findViewById<EditText>(R.id.campo_razao_social)
        val campoResponsavel = findViewById<EditText>(R.id.campo_responsavel)
        val campoTelefone = findViewById<EditText>(R.id.campo_telefone)
        val campoEmail = findViewById<EditText>(R.id.campo_email_empresa)
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar_cadastro)

        botaoSalvar.setOnClickListener {
            val cnpj = campoCNPJ.text.toString().trim()
            val razao = campoRazao.text.toString().trim()
            val resp = campoResponsavel.text.toString().trim()
            val fone = campoTelefone.text.toString().trim()
            val email = campoEmail.text.toString().trim()

            when {
                cnpj.isEmpty() || razao.isEmpty() || resp.isEmpty() -> {
                    Toast.makeText(this, "Preencha CNPJ, Razão Social e Responsável!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Cadastro salvo! Agora envie os documentos.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, TelaDocumentosEmpresa::class.java)
                    intent.putExtra("cnpj", cnpj)
                    intent.putExtra("razao", razao)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
