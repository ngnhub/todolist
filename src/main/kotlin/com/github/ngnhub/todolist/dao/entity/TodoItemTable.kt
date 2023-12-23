package com.github.ngnhub.todolist.dao.entity

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.timestamp

object TodoItemTable : LongIdTable("todo_item") {
    val title = text("title")
    val description = text("description")
    val createdAt = timestamp("created_at")
    val completeUntil = timestamp("complete_until")
    val status = enumerationByName<ItemStatus>("status", 20)

    enum class ItemStatus {
        DONE, CANCELED
    }
}
