package com.github.ngnhub.todolist.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/")
class TodoController {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(TodoController::class.java.simpleName)
    }

    @PostMapping
    fun create() {
        logger.info("Creates the item")
    }

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long): Any {
        return "Dummy item"
    }

    @PutMapping
    fun markAs(status: ItemStatus) {
        logger.info("Changing status to {}", status)
    }

    enum class ItemStatus {
        DONE, DELETED
    }
}