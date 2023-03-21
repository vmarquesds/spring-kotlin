package com.example.demo.infra.repository

import com.example.demo.infra.entity.CursoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<CursoEntity, Long> {
}