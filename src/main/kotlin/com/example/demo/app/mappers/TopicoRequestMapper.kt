package com.example.demo.app.mappers

import com.example.demo.app.request.TopicoRequest
import com.example.demo.app.request.UpdateTopicoRequest
import com.example.demo.core.domain.Curso
import com.example.demo.core.domain.Topico
import com.example.demo.core.domain.Usuario
import org.springframework.stereotype.Component

@Component
class TopicoRequestMapper() : Mapper<Topico, TopicoRequest> {

    private val curso = Curso(
        id = null,
        nome = "as",
        categoria = "as",
    )

    private val usuario = Usuario(
        id = null,
        nome = "as",
        email = "as@email.com"
    )

    override fun mapFrom(u: TopicoRequest): Topico {
        return Topico(
            titulo = u.titulo,
            mensagem = u.mensagem,
            curso = curso,
            autor = usuario
        )
        TODO("Colocar uma forma de buscar o curso e o autor")
    }

    fun mapFrom(u: UpdateTopicoRequest): Topico {
        return Topico(
            id = u.id,
            titulo = u.titulo,
            mensagem = u.mensagem,
            curso = curso,
            autor = usuario
        )
    }

    override fun mapTo(t: Topico): TopicoRequest {
        TODO("Not yet implemented")
    }
}