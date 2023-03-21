package com.example.demo.integration.model

import com.example.demo.core.domain.StatusTopico
import com.example.demo.infra.entity.TopicoEntity
import java.time.LocalDateTime

object TopicoEntityTest {
    fun build() = TopicoEntity(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        status = StatusTopico.NAO_RESPONDIDO,
        datacriacao = LocalDateTime.now(),
        autor = UsuarioEntityTest.build(),
        curso = CursoEntityTest.build(),
        respostas = listOf()
    )
}