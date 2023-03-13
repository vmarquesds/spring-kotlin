package com.example.demo.core.usecase

import com.example.demo.core.domain.Curso
import com.example.demo.infra.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoUseCase(private val repository: CursoRepository) {

    fun getById(id: Long): Curso {
        return repository.getReferenceById(id)
    }
}