package com.gestaofrotas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaDocumentosEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_documentos_empresa)

        val cnpj = intent.getStringExtra("cnpj") ?: ""
        val razao = intent.getStringExtra("razao") ?: ""

        findViewById<TextView>(R.id.empresa_nome).text = "$razao\nCNPJ: $cnpj"

        // Lista dos 5 documentos obrigatórios
        val listaDocs = DOCUMENTOS_OBRIGATORIOS
        val botoes = listOf<Button>(
            findViewById(R.id.doc1), findViewById(R.id.doc2),
            findViewById(R.id.doc3), findViewById(R.id.doc4),
            findViewById(R.id.doc5)
        )

        botoes.forEachIndexed { index, botao ->
            botao.text = listaDocs[index]
            botao.setOnClickListener {
                Toast.makeText(this, "Selecionando: ${listaDocs[index]}...", Toast.LENGTH_SHORT).show()
                // Aqui depois vamos adicionar a função de anexar arquivo
                botao.setBackgroundColor(0xFF4CAF50.toInt())
                botao.text = "✅ ${listaDocs[index]}"
            }
        }
    }
}
