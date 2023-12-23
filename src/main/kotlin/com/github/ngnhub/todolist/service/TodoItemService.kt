package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.model.TodoItem

interface TodoItemService {

    fun getBy(id: Long): TodoItem

//    fun create(): TodoItem
}
