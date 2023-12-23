package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityUpdate

interface TodoItemRepository {

    fun getBy(id: Long) : TodoItemEntity

    fun create(create: TodoItemEntityCreate)

    fun update(update: TodoItemEntityUpdate)
}
