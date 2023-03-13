package com.example.demo.port.input.response

import com.example.demo.core.domain.StatusTopico
import java.time.LocalDateTime

data class TopicoResponse(
    var id: Long?,
    var titulo: String,
    var mensagem: String,
    val status: StatusTopico,
    var datacriacao: LocalDateTime?,
)
