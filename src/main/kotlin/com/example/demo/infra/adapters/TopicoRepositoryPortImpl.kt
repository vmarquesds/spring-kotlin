package com.example.demo.infra.adapters

import com.example.demo.core.domain.Topico
import com.example.demo.core.exception.NotFoundException
import com.example.demo.core.ports.repositories.TopicoRepositoryPort
import com.example.demo.infra.repository.CursoRepository
import com.example.demo.infra.repository.TopicoRepository
import com.example.demo.infra.repository.UsuarioRepository
import com.example.demo.infra.mappers.TopicoEntityMapper
import org.springframework.stereotype.Repository
import java.util.stream.Collectors

@Repository
class TopicoRepositoryPortImpl(
    private val topicoRepository: TopicoRepository,
    private val usuarioRepository: UsuarioRepository,
    private val cursoRepository: CursoRepository,
    private val topicoEntityMapper: TopicoEntityMapper
) : TopicoRepositoryPort {

    override fun listAllTopicos(): List<Topico> {
        return topicoRepository.findAll().stream().map { t -> topicoEntityMapper.mapFrom(t) }
            .collect(Collectors.toList())
    }

    override fun getTopicoById(id: Long): Topico {
        return topicoEntityMapper.mapFrom(topicoRepository.findById(id).orElseThrow { NotFoundException("message") })
    }

    override fun createTopico(topico: Topico): Topico {
        val top = topicoEntityMapper.mapTo(topico)
        usuarioRepository.save(top.autor)
        cursoRepository.save(top.curso)
        return topicoEntityMapper.mapFrom(topicoRepository.save(top))
    }

    override fun updateTopico(topico: Topico): Topico {
        val topicoEntity = topicoRepository.findById(topico.id!!).orElseThrow { NotFoundException("Message") }
        topicoEntity.titulo = topico.titulo
        topicoEntity.mensagem = topico.mensagem
        return topicoEntityMapper.mapFrom(topicoEntity)
    }

    override fun deleteTopico(id: Long) {
        topicoRepository.deleteById(id)
    }
}