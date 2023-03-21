package com.example.demo.core.adapters

import com.example.demo.app.mappers.TopicoRequestMapper
import com.example.demo.app.mappers.TopicoResponseMapper
import com.example.demo.core.domain.TopicoRequestTest
import com.example.demo.core.domain.TopicoTest
import com.example.demo.core.ports.repositories.TopicoRepositoryPort
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TopicoServiceImplTest {

    private lateinit var topicoService: TopicoServiceImpl

    @MockK
    private lateinit var topicoRepository: TopicoRepositoryPort

    private val topicoMock = TopicoTest.build()
    private val topicoRequestMock = TopicoRequestTest.build()

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        topicoService = TopicoServiceImpl(topicoRepository, TopicoResponseMapper(), TopicoRequestMapper())
    }

    @Test
    fun listAllTopicos() {
        every { topicoRepository.listAllTopicos() } returns listOf(topicoMock, topicoMock)

        val topicos = topicoService.listAllTopicos()

        verify(exactly = 1) { topicoRepository.listAllTopicos() }
        assertEquals(2, topicos.size)
        assertEquals(topicoMock.titulo, topicos[0].titulo)
        assertEquals(topicoMock.mensagem, topicos[1].mensagem)
    }

    @Test
    fun createTopico() {
        every { topicoRepository.createTopico(any()) } returns topicoMock

        val topico = topicoService.createTopico(topicoRequestMock)

        verify(exactly = 1) { topicoRepository.createTopico(any()) }
        assertEquals(topicoMock.titulo, topico.titulo)
        assertEquals(topicoMock.mensagem, topico.mensagem)
    }
}