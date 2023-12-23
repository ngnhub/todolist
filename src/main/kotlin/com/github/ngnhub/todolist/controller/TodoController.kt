package com.github.ngnhub.todolist.controller

import com.github.ngnhub.todolist.logger
import com.github.ngnhub.todolist.service.TodoItemService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/")
class TodoController(private val service: TodoItemService) {

    @PostMapping
    fun create() {
        logger().info("Creates the item")
    }

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long): Any {
        return service.getBy(id)
    }

    @PutMapping
    fun markAs(status: ItemStatus) {
        logger().info("Changing status to {}", status)
    }

    enum class ItemStatus {
        DONE, DELETED
    }
}