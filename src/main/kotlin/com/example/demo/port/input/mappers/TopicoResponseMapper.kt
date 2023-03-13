package com.example.demo.port.input.mappers

import com.example.demo.core.domain.Topico
import com.example.demo.port.input.response.TopicoResponse
import org.springframework.stereotype.Component

@Component
class TopicoResponseMapper: Mapper<Topico, TopicoResponse> {
    override fun map(t: Topico): TopicoResponse {
        return TopicoResponse(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            datacriacao = t.datacriacao
        )
    }
}
