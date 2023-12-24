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
    fun `getBy should return entity by id`() {
        // given
        mockkObject(TodoItemEntity.Companion)
        val expected = getTodoItemEntity()
        every { TodoItemEntity.findById(DEFAULT_ID) } returns expected

        // when
        val actual = repository.getBy(DEFAULT_ID)

        // then
        assertEquals(expected, actual)
        verify(exactly = 1) { TodoItemEntity.findById(DEFAULT_ID) }
    }

    @Test
    fun `getBy should throw an exc if id is not found`() {
        // given
        mockkObject(TodoItemEntity.Companion)
        every { TodoItemEntity.findById(DEFAULT_ID) } returns null

        // when
        val exc = assertThrows<NotFoundException> { repository.getBy(DEFAULT_ID) }

        // then
        assertEquals("Item with id $DEFAULT_ID not found", exc.message)
        verify(exactly = 1) { TodoItemEntity.findById(DEFAULT_ID) }
    }

    @Test
    fun `create should invoke TodoItemEntity#new method`() {
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

    @Test
    fun `delete should invoke entity todoItemEntity#delete method`() {
        // given
        mockkObject(TodoItemEntity.Companion)
        val todoItemEntity = getTodoItemEntity()
        every { TodoItemEntity.findById(DEFAULT_ID) } returns todoItemEntity

        // when
        repository.delete(DEFAULT_ID)

        // then
        verify(exactly = 1) { todoItemEntity.delete() }
    }

    @Test
    fun `delete should throw an exc if id is not found`() {
        // given
        mockkObject(TodoItemEntity.Companion)
        every { TodoItemEntity.Companion.findById(any(Long::class)) } returns null
        val todoItemEntity = getTodoItemEntity()

        // when
        val exc = assertThrows<NotFoundException> { repository.delete(DEFAULT_ID) }

        // then
        assertEquals("Item with id $DEFAULT_ID not found", exc.message)
        verify(exactly = 1) { TodoItemEntity.Companion.findById(DEFAULT_ID) }
        verify(exactly = 0) { todoItemEntity.delete() }
    }
}
