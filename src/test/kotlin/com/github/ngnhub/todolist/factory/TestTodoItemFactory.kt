package com.github.ngnhub.todolist.factory

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemTable
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemTable.ItemStatus.DONE
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemTable.ItemStatus.OPEN
import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate
import io.mockk.every
import io.mockk.mockk
import org.jetbrains.exposed.dao.id.EntityID
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

object TestTodoItemFactory {

    private val createdAt: Instant = ZonedDateTime
        .of(2024, 1, 1, 0, 0, 0, 0, ZoneId.of("CET"))
        .toInstant()
    private val completeUntil: Instant = createdAt.plus(1, ChronoUnit.DAYS)
    private val remindAt: Instant = createdAt.plus(12, ChronoUnit.HOURS)

    fun getTodoItemEntity(): TodoItemEntity {
        val entity = mockk<TodoItemEntity>(relaxed = true)
        return entity.apply {
            every { id } returns EntityID(1L, TodoItemTable)
            every { title } returns "Test title"
            every { description } returns "Test description"
            every { createdAt } returns TestTodoItemFactory.createdAt
            every { completeUntil } returns TestTodoItemFactory.completeUntil
            every { status } returns OPEN
        }
    }

    fun getTodoItemEntityCreate() = TodoItemEntityCreate(
        "Test title",
        "Test description",
        createdAt,
        completeUntil,
        DONE,
        remindAt
    )

    fun getTodoItemCreate() = TodoItemCreate(
        "Test title",
        "Test description",
        completeUntil,
        remindAt
    )

    fun getTodoItemUpdate() = TodoItemUpdate(
        DEFAULT_ID,
        "Test title",
        "Test description",
        completeUntil,
        DONE,
        remindAt
    )
}
