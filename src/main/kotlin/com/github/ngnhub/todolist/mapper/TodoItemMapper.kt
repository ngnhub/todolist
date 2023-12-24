package com.github.ngnhub.todolist.mapper

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityUpdate
import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate

object TodoItemMapper {

    fun TodoItemEntity.toDto() = TodoItem(
        id.value,
        title,
        description,
        createdAt,
        completeUntil,
        status,
        remindAt
    )

    fun TodoItemUpdate.toEntity() = TodoItemEntityUpdate(
        id,
        title,
        description,
        completeUntil,
        status,
        remindAt
    )

    fun TodoItemCreate.toCreateEntity() = TodoItemEntityCreate(
        title = title,
        description = description,
        completeUntil = completeUntil,
        remindAt = remindAt
    )
}
