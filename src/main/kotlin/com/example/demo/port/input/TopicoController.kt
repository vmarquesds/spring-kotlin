package com.example.demo.port.input

import com.example.demo.core.usecase.TopicoUseCase
import com.example.demo.port.input.request.TopicoRequest
import com.example.demo.port.input.request.UpdateTopicoRequest
import com.example.demo.port.input.response.TopicoResponse
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
class TopicoController(private val topicoUseCase: TopicoUseCase) {

    @GetMapping
    @Cacheable("topicos")
    fun getTopicos(): List<TopicoResponse> {
        return topicoUseCase.listar()
    }

    @GetMapping("/{id}")
    fun getTopicosById(@PathVariable id: Long): TopicoResponse {
        return topicoUseCase.getById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun createTopico(
        @RequestBody @Valid topico: TopicoRequest
    ): ResponseEntity<TopicoResponse> {
        val topicoResponse = topicoUseCase.create(topico)
        return ResponseEntity.ok().body(topicoResponse)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun updateTopico(@RequestBody @Valid topico: UpdateTopicoRequest): ResponseEntity<TopicoResponse> {
        val topico = topicoUseCase.update(topico)
        return ResponseEntity.ok(topico)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun removeTopico(@PathVariable id: Long) {
        return topicoUseCase.delete(id)
    }
}