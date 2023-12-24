package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityUpdate

interface TodoItemRepository {

    fun listAll(): List<TodoItemEntity>

    fun getBy(id: Long): TodoItemEntity

    fun create(create: TodoItemEntityCreate): TodoItemEntity

    fun update(update: TodoItemEntityUpdate)

    fun delete(id: Long)
}
