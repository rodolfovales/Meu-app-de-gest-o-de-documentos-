package com.gestaofrotas

import android.net.Uri

data class Empresa(
    val id: String = System.currentTimeMillis().toString(),
    val cnpj: String,
    val razaoSocial: String,
    val arquivoCnpj: Uri?,
    val arquivoContratoSocial: Uri?,
    val arquivoSocios: Uri?,
    val arquivoEndereco: Uri?,
    val arquivoFaturamento: Uri?
)
