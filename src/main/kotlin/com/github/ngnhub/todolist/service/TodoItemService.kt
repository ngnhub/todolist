package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate

interface TodoItemService {

    fun getBy(id: Long): TodoItem

    fun create(create: TodoItemCreate)

    fun update(update: TodoItemUpdate)
}
