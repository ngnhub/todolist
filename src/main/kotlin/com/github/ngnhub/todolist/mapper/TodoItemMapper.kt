package com.github.ngnhub.todolist.mapper

import com.github.ngnhub.todolist.dao.entity.TodoItemEntity
import com.github.ngnhub.todolist.model.TodoItem
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface TodoItemMapper {

    @Mapping(target = "id", source = "entity.id.value")
    fun mapToDto(entity: TodoItemEntity): TodoItem
}
