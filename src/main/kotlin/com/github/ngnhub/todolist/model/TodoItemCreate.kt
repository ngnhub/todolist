package com.github.ngnhub.todolist.model

import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant

data class TodoItemCreate(
    @NotNull
    val title: String,
    val description: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val completeUntil: Instant,
)
