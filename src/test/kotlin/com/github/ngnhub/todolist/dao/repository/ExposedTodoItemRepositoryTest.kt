package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.exception.NotFoundException
import com.github.ngnhub.todolist.factory.DEFAULT_ID
import com.github.ngnhub.todolist.factory.TestTodoItemFactory.getTodoItemEntity
import com.github.ngnhub.todolist.factory.TestTodoItemFactory.getTodoItemEntityCreate
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// TODO: integration tests. no chance to test it clearly like that
class ExposedTodoItemRepositoryTest {

    private val repository: ExposedTodoItemRepository = ExposedTodoItemRepository()

    @Test
    fun testGetBy() {
        // given
        mockkObject(TodoItemEntity.Companion)
        val expected = getTodoItemEntity()
        every { TodoItemEntity.findById(1L) } returns expected

        // when
        val actual = repository.getBy(1L)

        // then
        assertEquals(expected, actual)
        verify(exactly = 1) { TodoItemEntity.findById(1L) }
    }

    @Test
    fun testGetByWhenNotFound() {
        // given
        mockkObject(TodoItemEntity.Companion)
        every { TodoItemEntity.findById(1L) } returns null

        // when
        val exc = assertThrows<NotFoundException> { repository.getBy(1L) }

        // then
        assertEquals("Item with id $DEFAULT_ID was not found", exc.message)
        verify(exactly = 1) { TodoItemEntity.findById(1L) }
    }

    @Test
    fun create() {
        // given
        val create = getTodoItemEntityCreate()
        mockkObject(TodoItemEntity.Companion)
        val entity = getTodoItemEntity()
        every { TodoItemEntity.new(any()) } returns entity

        // when
        repository.create(create)

        // then
        verify(exactly = 1) { TodoItemEntity.new(any()) }
    }

    @Disabled
    @Test
    fun update() {
        // TODO: integration tests
    }
}
