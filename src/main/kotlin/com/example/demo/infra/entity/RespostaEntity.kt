package com.example.demo.infra.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class RespostaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val autor: UsuarioEntity,
    @ManyToOne
    val topico: TopicoEntity,
    val solucao: Boolean,
)