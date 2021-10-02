package com.sp.cleanarchitectureapp.features.data.local.entities


fun Task.toDomain() : com.sp.cleanarchitectureapp.features.domain.model.Task{
    return com.sp.cleanarchitectureapp.features.domain.model.Task(
        id = this.taskId,
        content = this.content,
        timestamp = this.timestamp,
        todoId = this.todoId
    )
}

fun Todo.toDomain() : com.sp.cleanarchitectureapp.features.domain.model.Todo {
    return com.sp.cleanarchitectureapp.features.domain.model.Todo(
        id = this.todoId,
        title = this.title,
        timestamp = this.timestamp
    )
}

fun com.sp.cleanarchitectureapp.features.domain.model.Task.toEntity(): Task {
    return Task(
        taskId = this.id,
        content = this.content!!,
        timestamp = this.timestamp,
        todoId = this.todoId
    )
}

fun com.sp.cleanarchitectureapp.features.domain.model.Todo.toEntity(): Todo {
    return  Todo(
        todoId = this.id,
        title = this.title!!,
        timestamp = this.timestamp
    )
}
