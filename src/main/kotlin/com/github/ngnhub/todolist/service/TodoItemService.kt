package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate

interface TodoItemService {

    fun getBy(id: Long): TodoItem

    fun create(create: TodoItemCreate)
}
