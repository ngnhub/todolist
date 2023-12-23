package com.github.ngnhub.todolist.mapper

import com.github.ngnhub.todolist.dao.entity.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.TodoItemEntityCreate
import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate

object TodoItemMapper {

    fun TodoItemEntity.toDto() = TodoItem(id.value, title, description, createdAt, completeUntil, status)

    fun TodoItemCreate.toCreateEntity() = TodoItemEntityCreate(
        title = title,
        description = description,
        completeUntil = completeUntil
    )
}
