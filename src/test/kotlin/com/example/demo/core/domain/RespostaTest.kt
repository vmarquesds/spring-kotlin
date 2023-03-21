package com.example.demo.core.domain

import java.time.LocalDateTime

object RespostaTest {
    fun build() = Resposta(
        id = 1,
        mensagem = "Aprendendo kotlin basico",
        dataCriacao = LocalDateTime.now(),
        autor = Usuario(id = null, nome = "", email = ""),
        topico = TopicoTest.build(),
        solucao = false,

        )
}