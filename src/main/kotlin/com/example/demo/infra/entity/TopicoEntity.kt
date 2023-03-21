package com.example.demo.infra.entity

import com.example.demo.core.domain.StatusTopico
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class TopicoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    var datacriacao: LocalDateTime? = LocalDateTime.now(),
    @ManyToOne
    val curso: CursoEntity,
    @ManyToOne
    val autor: UsuarioEntity,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico")
    val respostas: List<RespostaEntity> = ArrayList()

)