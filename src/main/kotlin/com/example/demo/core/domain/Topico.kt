package com.example.demo.core.domain

import java.time.LocalDateTime

data class Topico(
    var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    var datacriacao: LocalDateTime? = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()

)