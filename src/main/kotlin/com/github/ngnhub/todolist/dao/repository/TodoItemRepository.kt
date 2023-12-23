package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.TodoItemEntity

interface TodoItemRepository {

    fun getBy(id: Long) : TodoItemEntity

    fun create(item: TodoItemEntity)
}
