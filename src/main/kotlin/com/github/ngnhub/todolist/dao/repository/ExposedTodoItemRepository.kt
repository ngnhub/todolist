package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityCreate
import com.github.ngnhub.todolist.dao.entity.too_item.TodoItemEntityUpdate
import com.github.ngnhub.todolist.exception.NotFoundException
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class ExposedTodoItemRepository : TodoItemRepository {

    @Transactional(readOnly = true)
    // Since Exposed requires transaction anyway, there is no reason to move it on the service layer
    override fun listAll() =
        TodoItemEntity.all().toList()

    @Transactional(readOnly = true)
    override fun getBy(id: Long) =
        TodoItemEntity.findByIdOrThrow(id)

    @Transactional
    override fun create(create: TodoItemEntityCreate) =
        TodoItemEntity.new {
            title = create.title
            description = create.description
            createdAt = create.createdAt
            completeUntil = create.completeUntil
            status = create.status
            remindAt = create.remindAt
        }

    @Transactional
    override fun update(update: TodoItemEntityUpdate) {
        val found = TodoItemEntity.findByIdOrThrow(update.id)
        with(found) {
            title = update.title
            description = update.description
            completeUntil = update.completeUntil
            status = update.status
            remindAt = update.remindAt
        }
    }

    @Transactional
    override fun delete(id: Long) =
        TodoItemEntity.findByIdOrThrow(id).delete()

    private fun TodoItemEntity.Companion.findByIdOrThrow(id: Long) =
        findById(id) ?: throw NotFoundException("Item with id $id not found")
}
