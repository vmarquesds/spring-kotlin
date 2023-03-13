package com.example.demo.infra.repository

import com.example.demo.core.domain.Topico
import com.example.demo.infra.TopicoPorCategoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long> {


    @Query("SELECT new com.example.demo.infra.TopicoPorCategoria(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoria>
}