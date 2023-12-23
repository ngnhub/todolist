package com.github.ngnhub.todolist.controller

import com.github.ngnhub.todolist.dao.entity.TodoItemTable.ItemStatus
import com.github.ngnhub.todolist.logger
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.service.TodoItemService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@Validated
@RestController
@RequestMapping("/")
class TodoController(private val service: TodoItemService) {

    @PostMapping
    fun create(@RequestBody create: TodoItemCreate) {
        service.create(create)
    }

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long): Any {
        return service.getBy(id)
    }

    @PutMapping
    fun markAs(status: ItemStatus) {
        logger().info("Changing status to {}", status)
    }
}