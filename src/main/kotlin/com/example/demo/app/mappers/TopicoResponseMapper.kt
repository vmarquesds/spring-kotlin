package com.example.demo.app.mappers

import com.example.demo.core.domain.Topico
import com.example.demo.app.response.TopicoResponse
import org.springframework.stereotype.Component

@Component
class TopicoResponseMapper: Mapper<Topico, TopicoResponse> {
    override fun mapTo(t: Topico): TopicoResponse {
        return TopicoResponse(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            datacriacao = t.datacriacao
        )
    }

    override fun mapFrom(u: TopicoResponse): Topico {
        TODO("Not yet implemented")
    }
}
