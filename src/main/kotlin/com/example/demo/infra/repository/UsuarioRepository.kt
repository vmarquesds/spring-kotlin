package com.example.demo.infra.repository

import com.example.demo.infra.entity.UsuarioEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<UsuarioEntity, Long> {
}