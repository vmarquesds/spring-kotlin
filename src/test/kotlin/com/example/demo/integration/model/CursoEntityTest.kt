package com.example.demo.integration.model

import com.example.demo.infra.entity.CursoEntity

object CursoEntityTest {
    fun build() = CursoEntity(id = 1, nome = "Kotlin Basico", categoria = "Programacao")
}