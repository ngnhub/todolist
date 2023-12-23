package com.github.ngnhub.todolist.dao.entity.too_item

import java.time.Instant

class TodoItemEntityUpdate(
    val id: Long,
    val title: String,
    val description: String?,
    val completeUntil: Instant?,
    val status: TodoItemTable.ItemStatus
)
