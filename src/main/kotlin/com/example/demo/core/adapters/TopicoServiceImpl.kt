package com.example.demo.core.adapters

import com.example.demo.app.mappers.TopicoRequestMapper
import com.example.demo.app.mappers.TopicoResponseMapper
import com.example.demo.app.request.TopicoRequest
import com.example.demo.app.request.UpdateTopicoRequest
import com.example.demo.app.response.TopicoResponse
import com.example.demo.core.ports.interfaces.TopicoServicePort
import com.example.demo.core.ports.repositories.TopicoRepositoryPort
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoServiceImpl(
    val topicoRepository: TopicoRepositoryPort,
    private val topicoResponseMapper: TopicoResponseMapper,
    private val topicoRequestMapper: TopicoRequestMapper
) : TopicoServicePort {

    override fun listAllTopicos(): List<TopicoResponse> {
        return topicoRepository.listAllTopicos().stream().map { t -> topicoResponseMapper.mapTo(t) }
            .collect(Collectors.toList())
    }

    override fun getTopicoById(id: Long): TopicoResponse {
        return topicoResponseMapper.mapTo(topicoRepository.getTopicoById(id))
    }

    override fun createTopico(topicoRequest: TopicoRequest): TopicoResponse {
        val topico = topicoRequestMapper.mapFrom(topicoRequest)
        // faz a regra de negocio e devolve o response

        return topicoResponseMapper.mapTo(topicoRepository.createTopico(topico))
    }

    override fun updateTopico(updateTopicoRequest: UpdateTopicoRequest): TopicoResponse {
        val topico = topicoRequestMapper.mapFrom(updateTopicoRequest)
        return topicoResponseMapper.mapTo(topicoRepository.updateTopico(topico))
    }

    override fun deleteTopico(id: Long) {
        return topicoRepository.deleteTopico(id)
    }
}