package com.example.demo.port.input.mappers


interface Mapper<T, U> {

    fun map(t: T): U
}