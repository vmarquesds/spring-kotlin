package com.example.demo.core.domain

import java.time.LocalDateTime

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        status = StatusTopico.NAO_RESPONDIDO,
        datacriacao = LocalDateTime.now(),
        autor = UsuarioTest.build(),
        curso = CursoTest.build(),
        respostas = listOf()
    )
}