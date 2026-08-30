package com.gestaofrotas

object ListaEmpresas {
    private val lista = mutableListOf<Empresa>()

    fun adicionar(empresa: Empresa) {
        lista.add(empresa)
    }

    fun listar(): List<Empresa> {
        return lista.toList()
    }

    fun limpar() {
        lista.clear()
    }
}
