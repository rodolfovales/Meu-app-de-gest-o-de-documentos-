    private fun enviarCadastro() {
        val cnpjTexto = findViewById<android.widget.EditText>(R.id.et_cnpj).text.toString().trim()
        val razaoTexto = findViewById<android.widget.EditText>(R.id.et_razao_social).text.toString().trim()

        if (cnpjTexto.isBlank() || razaoTexto.isBlank()) {
            Toast.makeText(this, "⚠️ Preencha CNPJ e Razão Social!", Toast.LENGTH_LONG).show()
            return
        }

        if (arquivoCnpj == null || arquivoContratoSocial == null || arquivoSocios == null ||
            arquivoEndereco == null || arquivoFaturamento == null) {
            Toast.makeText(this, "⚠️ Anexe TODOS os documentos antes de enviar!", Toast.LENGTH_LONG).show()
            return
        }

        // Salva a empresa na lista compartilhada
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
