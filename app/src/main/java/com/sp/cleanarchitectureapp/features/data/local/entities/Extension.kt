package com.sp.cleanarchitectureapp.features.data.local.entities


fun Task.toDomain() : com.sp.cleanarchitectureapp.features.domain.model.Task{
    return com.sp.cleanarchitectureapp.features.domain.model.Task(
        id = this.id!!,
        content = this.content!!,
        timestamp = this.timestamp,
        todo = this.todoGroup?.toDomain()
    )
}

fun Todo.toDomain() : com.sp.cleanarchitectureapp.features.domain.model.Todo{
    return com.sp.cleanarchitectureapp.features.domain.model.Todo(
        id = this.id!!,
        title = this.title!!,
        timestamp = this.timestamp
    )
}

fun com.sp.cleanarchitectureapp.features.domain.model.Task.toEntity(): Task {
    return Task(
        id = this.id,
        content = this.content,
        timestamp = this.timestamp,
        todoGroup = this.todo.toEntity()
    )
}

fun com.sp.cleanarchitectureapp.features.domain.model.Todo?.toEntity(): Todo? {
    return this?.let {
        Todo(
            id = it.id,
            title = it.title,
            timestamp = it.timestamp
        )
    }
}
