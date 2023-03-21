package com.example.demo.app

import com.example.demo.app.request.TopicoRequest
import com.example.demo.app.request.UpdateTopicoRequest
import com.example.demo.app.response.TopicoResponse
import com.example.demo.core.ports.interfaces.TopicoServicePort
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoServicePort: TopicoServicePort) {

    @GetMapping
    @Cacheable("topicos")
    fun getTopicos(): List<TopicoResponse> {
        return topicoServicePort.listAllTopicos()
    }

    @GetMapping("/{id}")
    fun getTopicosById(@PathVariable id: Long): TopicoResponse {
        return topicoServicePort.getTopicoById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun createTopico(
        @RequestBody @Valid topico: TopicoRequest
    ): ResponseEntity<TopicoResponse> {
        val topicoResponse = topicoServicePort.createTopico(topico)
        return ResponseEntity.ok().body(topicoResponse)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun updateTopico(@RequestBody @Valid topico: UpdateTopicoRequest): ResponseEntity<TopicoResponse> {
        val topico = topicoServicePort.updateTopico(topico)
        return ResponseEntity.ok(topico)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun removeTopico(@PathVariable id: Long) {
        return topicoServicePort.deleteTopico(id)
    }
}