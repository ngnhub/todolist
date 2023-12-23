package com.github.ngnhub.todolist.dao.entity.too_item

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TodoItemEntity(id: EntityID<Long>) : Entity<Long>(id) {
    companion object : EntityClass<Long, TodoItemEntity>(TodoItemTable)

    var title by TodoItemTable.title
    var description by TodoItemTable.description
    var createdAt by TodoItemTable.createdAt
    var completeUntil by TodoItemTable.completeUntil
    var status by TodoItemTable.status
}
