package com.github.ngnhub.todolist.dao.entity

import com.github.ngnhub.todolist.dao.entity.TodoItemTable.ItemStatus.OPEN
import java.time.Instant

data class TodoItemEntityCreate(
    val title: String,
    val description: String,
    val createdAt: Instant = Instant.now(),
    val completeUntil: Instant,
    val status: TodoItemTable.ItemStatus = OPEN
)
