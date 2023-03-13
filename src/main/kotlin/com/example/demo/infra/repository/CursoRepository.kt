package com.example.demo.infra.repository

import com.example.demo.core.domain.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}