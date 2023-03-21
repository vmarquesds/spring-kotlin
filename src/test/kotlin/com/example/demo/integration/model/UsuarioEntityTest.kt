package com.example.demo.integration.model

import com.example.demo.infra.entity.UsuarioEntity

object UsuarioEntityTest {
    fun build() = UsuarioEntity(id = 1, nome = "Joao", email = "jvc.martins")
    fun buildToToken() = UsuarioEntity(nome = "Ana da Silva", email = "ana@email.com")
}