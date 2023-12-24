package com.github.ngnhub.todolist.model

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemTable.ItemStatus
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant

data class TodoItem(
    val id: Long,
    val title: String,
    val description: String?,
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val createdAt: Instant,
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val completeUntil: Instant?,
    val status: ItemStatus,
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val remindAt: Instant?
)
