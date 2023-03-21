package com.example.demo.app.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicoRequest (
    @field:NotNull
    var id : Long,

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    var titulo: String,

    @field:NotEmpty
    var mensagem: String,
)
