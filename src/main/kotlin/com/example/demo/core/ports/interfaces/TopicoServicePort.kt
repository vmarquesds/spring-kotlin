package com.example.demo.core.ports.interfaces

import com.example.demo.app.request.TopicoRequest
import com.example.demo.app.request.UpdateTopicoRequest
import com.example.demo.app.response.TopicoResponse

interface TopicoServicePort {

    fun listAllTopicos(): List<TopicoResponse>

    fun getTopicoById(id: Long): TopicoResponse

    fun createTopico(topicoRequest: TopicoRequest): TopicoResponse

    fun updateTopico(topicoRequest: UpdateTopicoRequest): TopicoResponse

    fun deleteTopico(id: Long)
}