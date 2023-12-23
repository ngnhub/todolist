package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.dao.repository.TodoItemRepository
import com.github.ngnhub.todolist.mapper.TodoItemMapper
import com.github.ngnhub.todolist.model.TodoItem
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class TodoItemServiceImpl(private val repository: TodoItemRepository) : TodoItemService {

    val mapper: TodoItemMapper = Mappers.getMapper(TodoItemMapper::class.java)

    final override fun getBy(id: Long): TodoItem {
        val entity = repository.getBy(id)
        return mapper.mapToDto(entity)
    }
}
