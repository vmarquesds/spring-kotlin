package com.example.demo.core.domain

object UsuarioTest {
    fun build() = Usuario(id = 1, nome = "Joao", email = "jvc.martins")
    fun buildToToken() = Usuario(nome = "Ana da Silva", email = "ana@email.com")
}