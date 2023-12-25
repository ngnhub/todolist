package com.github.ngnhub.todolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// TODO: dashboards (opt)
// TODO: basic auth (opt)
// TODO: error handling (BE + FE)
// TODO: integration tests
@SpringBootApplication
class TodolistApplication

fun main(args: Array<String>) {
    runApplication<TodolistApplication>(*args)
}
