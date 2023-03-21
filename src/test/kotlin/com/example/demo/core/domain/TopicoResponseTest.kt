package com.example.demo.core.domain

import com.example.demo.app.response.TopicoResponse
import java.time.LocalDateTime

object TopicoResponseTest {
    fun build() = TopicoResponse(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        status = StatusTopico.NAO_RESPONDIDO,
        datacriacao = LocalDateTime.now(),
    )
}