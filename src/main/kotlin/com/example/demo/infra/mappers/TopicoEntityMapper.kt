package com.example.demo.infra.mappers

import com.example.demo.app.mappers.Mapper
import com.example.demo.core.domain.Topico
import com.example.demo.infra.entity.TopicoEntity
import org.springframework.stereotype.Component

@Component
class TopicoEntityMapper(
    private val cursoEntityMapper: CursoEntityMapper,
    private val usuarioEntityMapper: UsuarioEntityMapper
): Mapper<Topico, TopicoEntity> {
    override fun mapTo(t: Topico): TopicoEntity {
        return TopicoEntity(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoEntityMapper.mapTo(t.curso),
            autor = usuarioEntityMapper.mapTo(t.autor)
        )
    }

    override fun mapFrom(u: TopicoEntity): Topico {
        return Topico(
            titulo = u.titulo,
            mensagem = u.mensagem,
            curso = cursoEntityMapper.mapFrom(u.curso),
            autor = usuarioEntityMapper.mapFrom(u.autor)
        )
    }

}