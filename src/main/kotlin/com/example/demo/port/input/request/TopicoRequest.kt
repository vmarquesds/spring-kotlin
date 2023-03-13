package com.example.demo.port.input.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class TopicoRequest(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    var titulo: String,

    @field:NotEmpty var
    mensagem: String,

    @field:NotNull val
    idCurso: Long,

    @field:NotNull val
    idAutor: Long
)
