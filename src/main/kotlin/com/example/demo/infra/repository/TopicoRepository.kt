package com.example.demo.infra.repository

import com.example.demo.infra.entity.TopicoPorCategoria
import com.example.demo.infra.entity.TopicoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<TopicoEntity, Long> {


    @Query("SELECT new com.example.demo.infra.entity.TopicoPorCategoria(curso.categoria, count(t)) FROM TopicoEntity t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoria>
}