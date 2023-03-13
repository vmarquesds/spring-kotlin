package com.example.demo.port.input.response

import java.time.LocalDateTime

data class ErrorResponse(

    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
