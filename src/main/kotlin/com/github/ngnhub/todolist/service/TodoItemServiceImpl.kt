package com.github.ngnhub.todolist.service

import com.github.ngnhub.todolist.dao.repository.TodoItemRepository
import com.github.ngnhub.todolist.mapper.TodoItemMapper.toCreateEntity
import com.github.ngnhub.todolist.mapper.TodoItemMapper.toDto
import com.github.ngnhub.todolist.mapper.TodoItemMapper.toEntity
import com.github.ngnhub.todolist.model.TodoItem
import com.github.ngnhub.todolist.model.TodoItemCreate
import com.github.ngnhub.todolist.model.TodoItemUpdate
import org.springframework.stereotype.Service

@Service
class TodoItemServiceImpl(private val repository: TodoItemRepository) : TodoItemService {

    final override fun getBy(id: Long): TodoItem {
        return repository.getBy(id).toDto()
    }

    override fun create(create: TodoItemCreate) {
        repository.create(create.toCreateEntity())
    }

    override fun update(update: TodoItemUpdate) {
        repository.update(update.toEntity())
    }
}
