package com.example.demo.infra.repository

import com.example.demo.core.domain.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}