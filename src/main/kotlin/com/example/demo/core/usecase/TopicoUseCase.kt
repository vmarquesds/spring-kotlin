package com.example.demo.core.usecase

import com.example.demo.core.exception.NotFoundException
import com.example.demo.infra.repository.TopicoRepository
import com.example.demo.port.input.mappers.TopicoRequestMapper
import com.example.demo.port.input.mappers.TopicoResponseMapper
import com.example.demo.port.input.request.TopicoRequest
import com.example.demo.port.input.request.UpdateTopicoRequest
import com.example.demo.port.input.response.TopicoResponse
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoUseCase(
    private var repository: TopicoRepository,
    private val cursoUseCase: CursoUseCase,
    private val autorUseCase: AutorUseCase,
    private val topicoResponseMapper: TopicoResponseMapper,
    private val topicoRequestMapper: TopicoRequestMapper
) {

    fun listar(): List<TopicoResponse> {
        return repository.findAll().stream().map { t -> topicoResponseMapper.map(t) }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicoResponse {
        return topicoResponseMapper.map(repository.findById(id).orElseThrow { NotFoundException("Message") })
    }

    fun create(topicoRequest: TopicoRequest): TopicoResponse {
        val topico = topicoRequestMapper.map(topicoRequest)
        repository.save(topico)

        return topicoResponseMapper.map(topico)
    }

    fun update(topicoRequest: UpdateTopicoRequest): TopicoResponse {
        val topico = repository.findById(topicoRequest.id).orElseThrow { NotFoundException("Message") }
        topico.titulo = topicoRequest.titulo
        topico.mensagem = topicoRequest.mensagem

        return topicoResponseMapper.map(topico)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}