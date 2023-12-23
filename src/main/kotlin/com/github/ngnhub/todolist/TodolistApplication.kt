package com.github.ngnhub.todolist

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodolistApplication

fun main(args: Array<String>) {
    runApplication<TodolistApplication>(*args)
}

fun <T : Any> T.logger() : Logger = LoggerFactory.getLogger(javaClass)
