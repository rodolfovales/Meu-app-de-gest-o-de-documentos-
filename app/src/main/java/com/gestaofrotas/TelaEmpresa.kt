package com.gestaofrotas

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class TelaEmpresa : AppCompatActivity() {

    private lateinit var txtCnpj: TextView
    private lateinit var txtContratoSocial: TextView
    private lateinit var txtSocios: TextView
    private lateinit var txtEndereco: TextView
    private lateinit var txtFaturamento: TextView

    private var arquivoCnpj: Uri? = null
    private var arquivoContratoSocial: Uri? = null
    private var arquivoSocios: Uri? = null
    private var arquivoEndereco: Uri? = null
    private var arquivoFaturamento: Uri? = null

    private val escolherArquivo = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { resultado ->
        if (resultado.resultCode == RESULT_OK) {
            val uri = resultado.data?.data
            uri?.let {
                val nomeArquivo = getNomeArquivo(it)
                when (ultimoBotaoClicado) {
                    1 -> { arquivoCnpj = it; txtCnpj.text = "✅ $nomeArquivo" }
                    2 -> { arquivoContratoSocial = it; txtContratoSocial.text = "✅ $nomeArquivo" }
                    3 -> { arquivoSocios = it; txtSocios.text = "✅ $nomeArquivo" }
                    4 -> { arquivoEndereco = it; txtEndereco.text = "✅ $nomeArquivo" }
                    5 -> { arquivoFaturamento = it; txtFaturamento.text = "✅ $nomeArquivo" }
                }
                Toast.makeText(this, "Arquivo anexado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private var ultimoBotaoClicado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_empresa)

        txtCnpj = findViewById(R.id.txt_cnpj)
        txtContratoSocial = findViewById(R.id.txt_contrato_social)
        txtSocios = findViewById(R.id.txt_socios)
        txtEndereco = findViewById(R.id.txt_endereco)
        txtFaturamento = findViewById(R.id.txt_faturamento)

        findViewById<Button>(R.id.btn_cnpj).setOnClickListener { abrirSeletor(1) }
        findViewById<Button>(R.id.btn_contrato_social).setOnClickListener { abrirSeletor(2) }
        findViewById<Button>(R.id.btn_socios).setOnClickListener { abrirSeletor(3) }
        findViewById<Button>(R.id.btn_endereco).setOnClickListener { abrirSeletor(4) }
        findViewById<Button>(R.id.btn_faturamento).setOnClickListener { abrirSeletor(5) }

        findViewById<Button>(R.id.botao_cadastrar).setOnClickListener {
            enviarCadastro()
        }
    }

    private fun abrirSeletor(tipo: Int) {
        ultimoBotaoClicado = tipo
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        escolherArquivo.launch(Intent.createChooser(intent, "Selecione o arquivo"))
    }

    private fun getNomeArquivo(uri: Uri): String {
        var nome = "Arquivo selecionado"
        contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val indice = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                if (indice >= 0) nome = cursor.getString(indice)
            }
        }
        return nome
    }

    private fun enviarCadastro() {
        val campoCnpj = findViewById<EditText>(R.id.et_cnpj)
        val campoRazao = findViewById<EditText>(R.id.et_razao_social)
        val cnpjTexto = campoCnpj.text.toString().trim()
        val razaoTexto = campoRazao.text.toString().trim()

        if (cnpjTexto.isBlank() || razaoTexto.isBlank()) {
            Toast.makeText(this, "⚠️ Preencha CNPJ e Razão Social!", Toast.LENGTH_LONG).show()
            return
        }

        if (arquivoCnpj == null || arquivoContratoSocial == null || arquivoSocios == null ||
            arquivoEndereco == null || arquivoFaturamento == null) {
            Toast.makeText(this, "⚠️ Anexe TODOS os documentos antes de enviar!", Toast.LENGTH_LONG).show()
            return
        }

        val novaEmpresa = Empresa(
            cnpj = cnpjTexto,
            razaoSocial = razaoTexto,
            arquivoCnpj = arquivoCnpj,
            arquivoContratoSocial = arquivoContratoSocial,
            arquivoSocios = arquivoSocios,
            arquivoEndereco = arquivoEndereco,
            arquivoFaturamento = arquivoFaturamento
        )
        ListaEmpresas.adicionar(novaEmpresa)

        Toast.makeText(this, "✅ Cadastro enviado com sucesso! Obrigado!", Toast.LENGTH_LONG).show()
        finish()
    }
}
