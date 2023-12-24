package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityUpdate
import com.github.ngnhub.todolist.exception.NotFoundException
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class ExposedTodoItemRepository : TodoItemRepository {

    @Transactional(readOnly = true) // Exposed requires transaction even for reading. srsly?
    override fun listAll(): List<TodoItemEntity> {
        return TodoItemEntity.all().toList()
    }

    @Transactional(readOnly = true)
    override fun getBy(id: Long): TodoItemEntity {
        return TodoItemEntity.findById(id) ?: throw NotFoundException("Item with id $id was not found")
    }

    @Transactional
    override fun create(create: TodoItemEntityCreate) = TodoItemEntity.new {
        title = create.title
        description = create.description
        createdAt = create.createdAt
        completeUntil = create.completeUntil
        status = create.status
    }

    @Transactional
    override fun update(update: TodoItemEntityUpdate) {
        val found = TodoItemEntity.findById(update.id)
            ?: throw NotFoundException("Item with id ${update.id} not found")
        with(found) {
            title = update.title
            description = update.description
            completeUntil = update.completeUntil
            status = update.status
        }
    }
}
