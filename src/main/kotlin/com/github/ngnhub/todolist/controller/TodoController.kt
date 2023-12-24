package com.github.ngnhub.todolist.controller

import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate
import com.github.ngnhub.todolist.service.TodoItemService
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

// TODO: dasboards (opt)
// TODO: basic auth (opt)
// TODO: telegram sending and planning
// TODO: error handling (BE + FE)
@Validated
@RestController
@RequestMapping("/api/todo")
class TodoController(private val service: TodoItemService) {

    @GetMapping
    fun listAll() = service.listAll()

    @PostMapping
    fun create(@Valid @RequestBody create: TodoItemCreate) = service.create(create)

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long) = service.getBy(id)

    @PutMapping
    fun update(@Valid @RequestBody update: TodoItemUpdate) = service.update(update)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
