package com.github.ngnhub.todolist.dao.repository

import com.github.ngnhub.todolist.dao.entity.TodoItemEntity
import com.github.ngnhub.todolist.dao.entity.TodoItemEntityCreate
import com.github.ngnhub.todolist.exception.NotFoundException
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class ExposedTodoItemRepository : TodoItemRepository {

    @Transactional(readOnly = true) // Exposed requires transaction even for reading. srsly?
    override fun getBy(id: Long): TodoItemEntity {
        return TodoItemEntity.findById(id) ?: throw NotFoundException("Item with id $id not found")
    }

    @Transactional
    override fun create(item: TodoItemEntityCreate) {
        TodoItemEntity.new {
            title = item.title
            description = item.description
            createdAt = item.createdAt
            completeUntil = item.completeUntil
            status = item.status
        }
    }

//    private fun TodoItemEntityCreate.insertFrom(): TodoItemEntity.() -> Unit {
//        return {
//            title = item.title
//            description = item.description
//            createdAt = item.createdAt
//            completeUntil = item.completeUntil
//            status = item.status
//        }
//}
}
