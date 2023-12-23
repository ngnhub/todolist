package com.github.ngnhub.todolist.controller

import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate
import com.github.ngnhub.todolist.service.TodoItemService
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@Validated
@RestController
@RequestMapping("/todo")
class TodoController(private val service: TodoItemService) {

    @PostMapping
    fun create(@Valid @RequestBody create: TodoItemCreate) {
        service.create(create)
    }

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long): TodoItem {
        return service.getBy(id)
    }

    @PutMapping
    fun update(@Valid @RequestBody update: TodoItemUpdate) {
        service.update(update)
    }
}
