package com.example.demo.integration

import com.example.demo.infra.entity.TopicoPorCategoria
import com.example.demo.infra.repository.CursoRepository
import com.example.demo.infra.repository.TopicoRepository
import com.example.demo.infra.repository.UsuarioRepository
import com.example.demo.integration.model.CursoEntityTest
import com.example.demo.integration.model.TopicoEntityTest
import com.example.demo.integration.model.UsuarioEntityTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest {

    @Autowired
    lateinit var topicoRepository: TopicoRepository
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    @Autowired
    lateinit var cursoRepository: CursoRepository


    private val topico = TopicoEntityTest.build()

    companion object {
        @Container
        private val mysqlContainer = MySQLContainer<Nothing>("mysql:latest").apply {
            withDatabaseName("testdb")
            withUsername("joao")
            withPassword("12345")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
            registry.add("spring.datasource.password", mysqlContainer::getPassword);
            registry.add("spring.datasource.username", mysqlContainer::getUsername);
        }
    }

    @Test
    fun `deve gerar um relatorio`() {
        usuarioRepository.save(UsuarioEntityTest.build())
        cursoRepository.save(CursoEntityTest.build())
        topicoRepository.save(topico)
        val relatorio = topicoRepository.relatorio()

        assertThat(relatorio).isNotNull
        assertThat(relatorio.first()).isExactlyInstanceOf(TopicoPorCategoria::class.java)
    }

}