package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityUpdate
import com.github.ngnhub.todolist.dao.repository.TodoItemRepository
import com.github.ngnhub.todolist.factory.DEFAULT_ID
import com.github.ngnhub.todolist.factory.TestTodoItemFactory.getTodoItemCreate
import com.github.ngnhub.todolist.factory.TestTodoItemFactory.getTodoItemEntity
import com.github.ngnhub.todolist.factory.TestTodoItemFactory.getTodoItemUpdate
import com.github.ngnhub.todolist.mapper.TodoItemMapper.toCreateEntity
import com.github.ngnhub.todolist.mapper.TodoItemMapper.toDto
import com.github.ngnhub.todolist.mapper.TodoItemMapper.toEntity
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TodoItemServiceImplTest {
    private lateinit var service: TodoItemServiceImpl
    private val repository: TodoItemRepository = mockk(relaxed = true)

    @BeforeEach
    fun setUp() {
        service = TodoItemServiceImpl(repository)
    }

    @Test
    fun `getBy id should return a TodoItem`() {
        // given
        val expectedTodoItem = getTodoItemEntity()
        every { repository.getBy(DEFAULT_ID) } returns expectedTodoItem

        // when
        val actual = service.getBy(DEFAULT_ID)

        // then
        assertEquals(expectedTodoItem.toDto(), actual)
        verify(exactly = 1) { repository.getBy(DEFAULT_ID) }
    }

    @Test
    fun `create should add a new TodoItem`() {
        // given
        val create = getTodoItemCreate()
        val slot = slot<TodoItemEntityCreate>()
        every { repository.create(capture(slot)) } returns Unit

        // when
        service.create(create)

        // then
        val captured = slot.captured
        val actual = create.toCreateEntity()

        assertThat(captured)
            .usingRecursiveComparison()
            .ignoringFields("createdAt")
            .isEqualTo(actual)
        verify(exactly = 1) { repository.create(any()) }
    }

    @Test
    fun `update should modify an existing TodoItem`() {
        // given
        val update = getTodoItemUpdate()
        val slot = slot<TodoItemEntityUpdate>()
        every { repository.update(capture(slot)) } returns Unit

        // when
        service.update(update)

        // then
        val captured = slot.captured
        val actual = update.toEntity()

        assertThat(captured)
            .usingRecursiveComparison()
            .ignoringFields("createdAt")
            .isEqualTo(actual)
        verify(exactly = 1) { repository.update(any()) }
    }
}
