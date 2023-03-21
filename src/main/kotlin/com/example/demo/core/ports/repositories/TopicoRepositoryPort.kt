package com.example.demo.core.ports.repositories

import com.example.demo.core.domain.Topico

interface TopicoRepositoryPort {

    fun listAllTopicos(): List<Topico>

    fun getTopicoById(id: Long): Topico

    fun createTopico(topico: Topico): Topico

    fun updateTopico(topico: Topico): Topico

    fun deleteTopico(id: Long)
}