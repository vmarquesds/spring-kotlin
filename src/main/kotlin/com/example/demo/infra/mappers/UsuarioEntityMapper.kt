package com.example.demo.infra.mappers

import com.example.demo.app.mappers.Mapper
import com.example.demo.core.domain.Usuario
import com.example.demo.infra.entity.UsuarioEntity
import org.springframework.stereotype.Component

@Component
class UsuarioEntityMapper(): Mapper<Usuario, UsuarioEntity> {
    override fun mapTo(t: Usuario): UsuarioEntity {
        return UsuarioEntity(
            nome = t.nome,
            email = t.email
        )
    }

    override fun mapFrom(u: UsuarioEntity): Usuario {
        return Usuario(
            nome = u.nome,
            email = u.email
        )
    }

}