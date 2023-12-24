package com.github.ngnhub.todolist.model

import jakarta.validation.constraints.Future
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant

data class TodoItemCreate(
    val title: String,
    val description: String?,
    @field:Future
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val completeUntil: Instant?,
    @Future
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val remindAt: Instant?
)
