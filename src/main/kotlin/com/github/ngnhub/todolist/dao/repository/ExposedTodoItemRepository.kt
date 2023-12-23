package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.TodoItemEntity
import com.github.ngnhub.todolist.exception.NotFoundException
import org.springframework.stereotype.Repository

@Repository
class ExposedTodoItemRepository : TodoItemRepository {

    override fun getBy(id: Long): TodoItemEntity {
        return TodoItemEntity.findById(id) ?: throw NotFoundException("Item with id $id not found")
    }

    override fun create(item: TodoItemEntity) {
        TodoItemEntity.new { insertFrom() }
    }

    private fun TodoItemEntity.insertFrom(): TodoItemEntity.() -> Unit {
        return {
            title = this@insertFrom.title
            description = this@insertFrom.description
            createdAt = this@insertFrom.createdAt
            completeUntil = this@insertFrom.completeUntil
            status = this@insertFrom.status
        }
    }
}
