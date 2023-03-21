package com.example.demo.app.mappers


interface Mapper<T, U> {

    fun mapTo(t: T): U
    fun mapFrom(u: U): T
}