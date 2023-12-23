package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.TodoItemEntityCreate

interface TodoItemRepository {

    fun getBy(id: Long) : TodoItemEntity

    fun create(item: TodoItemEntityCreate)
}
