package com.github.ngnhub.todolist.model

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemTable.ItemStatus
import jakarta.validation.constraints.Future
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant

data class TodoItemUpdate(
    val id: Long,
    val title: String,
    val description: String?,
    @field:Future
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val completeUntil: Instant?,
    val status: ItemStatus,
    @Future // TODO: validation - before completeUntil
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val remindAt: Instant?
)
