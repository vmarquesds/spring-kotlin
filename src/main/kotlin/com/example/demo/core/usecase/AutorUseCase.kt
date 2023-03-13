package com.example.demo.core.usecase

import com.example.demo.core.domain.Usuario
import com.example.demo.infra.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class AutorUseCase(private val repository: UsuarioRepository) {

    fun getById(id: Long): Usuario {
        return repository.getReferenceById(id)
    }
}
