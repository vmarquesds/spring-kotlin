package com.example.demo.core.domain

import com.example.demo.app.request.TopicoRequest

object TopicoRequestTest {
    fun build() = TopicoRequest(
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        idCurso = 1,
        idAutor = 1,
    )
}