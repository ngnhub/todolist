package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate

interface TodoItemService {

    fun listAll() : List<TodoItem>

    fun getBy(id: Long): TodoItem

    fun create(create: TodoItemCreate): TodoItem

    fun update(update: TodoItemUpdate)
}
