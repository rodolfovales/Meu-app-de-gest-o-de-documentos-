package com.gestaofrotas

data class Empresa(
    val cnpj: String,
    val razaoSocial: String,
    val responsavel: String,
    val telefone: String,
    val email: String
)

data class Documento(
    val id: Int,
    val cnpjEmpresa: String,
    val tipo: String,
    val nomeArquivo: String,
    val status: String = "PENDENTE",
    val comentario: String = ""
)

val DOCUMENTOS_OBRIGATORIOS = listOf(
    "Cartão CNPJ",
    "Contrato Social",
    "Documento de Identificação dos Sócios",
    "Comprovante de Endereço da Empresa",
    "Faturamento dos Últimos 12 Meses"
)
