package com.github.ngnhub.todolist.controller

import com.github.ngnhub.todolist.logger
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/")
class TodoController {

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