package com.example.demo.infra.mappers

import com.example.demo.app.mappers.Mapper
import com.example.demo.core.domain.Curso
import com.example.demo.infra.entity.CursoEntity
import org.springframework.stereotype.Component

@Component
class CursoEntityMapper(): Mapper<Curso, CursoEntity> {
    override fun mapTo(t: Curso): CursoEntity {
        return CursoEntity(
            nome = t.nome,
            categoria = t.categoria,
        )
    }

    override fun mapFrom(u: CursoEntity): Curso {
        return Curso(
            nome = u.nome,
            categoria = u.categoria,
        )
    }
}