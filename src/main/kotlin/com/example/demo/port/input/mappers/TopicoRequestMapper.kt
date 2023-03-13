package com.example.demo.port.input.mappers

import com.example.demo.core.domain.Topico
import com.example.demo.core.usecase.AutorUseCase
import com.example.demo.core.usecase.CursoUseCase
import com.example.demo.port.input.request.TopicoRequest
import org.springframework.stereotype.Component

@Component
class TopicoRequestMapper(
    private val cursoUseCase: CursoUseCase,
    private val autorUseCase: AutorUseCase,
): Mapper<TopicoRequest, Topico> {
    override fun map(t: TopicoRequest): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoUseCase.getById(t.idCurso),
            autor = autorUseCase.getById(t.idAutor)
        )
    }

}