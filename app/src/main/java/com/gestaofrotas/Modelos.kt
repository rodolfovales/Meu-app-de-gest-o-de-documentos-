package com.gestaofrotas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Empresa(
    @PrimaryKey val cnpj: String,
    val razaoSocial: String,
    val responsavel: String,
    val telefone: String,
    val email: String,
    val dataCadastro: Long = System.currentTimeMillis()
)

@Entity
data class Documento(
    @PrimaryKey val id: Int? = null,
    val cnpjEmpresa: String,
    val tipo: String,
    val nomeArquivo: String,
    val caminhoArquivo: String = "",
    val status: String = "PENDENTE",
    val comentario: String = "",
    val dataEnvio: Long = System.currentTimeMillis()
)

@Entity
data class Usuario(
    @PrimaryKey val email: String,
    val senha: String,
    val tipo: String // MASTER / EMPRESA
)

val DOCUMENTOS_OBRIGATORIOS = listOf(
    "Cartão CNPJ",
    "Contrato Social",
    "Documento de Identificação dos Sócios",
    "Comprovante de Endereço da Empresa",
    "Faturamento dos Últimos 12 Meses"
)
