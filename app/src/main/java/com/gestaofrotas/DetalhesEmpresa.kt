package com.gestaofrotas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalhesEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhes_empresa)

        val razao = intent.getStringExtra("razao") ?: ""
        val cnpj = intent.getStringExtra("cnpj") ?: ""

        findViewById<TextView>(R.id.detalhe_nome).text = razao
        findViewById<TextView>(R.id.detalhe_cnpj).text = "CNPJ: $cnpj"

        val listaDocs = DOCUMENTOS_OBRIGATORIOS
        val botoes = listOf<Button>(
            findViewById(R.id.doc1), findViewById(R.id.doc2),
            findViewById(R.id.doc3), findViewById(R.id.doc4),
            findViewById(R.id.doc5)
        )

        botoes.forEachIndexed { index, botao ->
            botao.text = "✅ ${listaDocs[index]}"
            botao.setBackgroundColor(0xFF4CAF50.toInt())
        }

        // Ações de análise
        findViewById<Button>(R.id.botao_aprovado).setOnClickListener {
            findViewById<TextView>(R.id.status_atual).text = "✅ APROVADO"
            Toast.makeText(this, "Empresa aprovada!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.botao_rejeitado).setOnClickListener {
            findViewById<TextView>(R.id.status_atual).text = "❌ REJEITADO"
            Toast.makeText(this, "Empresa rejeitada!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.botao_salvar_comentario).setOnClickListener {
            val comentario = findViewById<EditText>(R.id.campo_comentario).text.toString()
            if (comentario.isNotEmpty()) {
                Toast.makeText(this, "Comentário salvo!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
