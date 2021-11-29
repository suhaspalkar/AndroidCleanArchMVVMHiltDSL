package com.sp.cleanarchitectureapp.features.domain.model

import com.sp.cleanarchitectureapp.features.data.local.entities.Task as TaskEntity
import com.sp.cleanarchitectureapp.features.data.local.entities.TaskList as TaskListEntity

data class TaskList(val taskListId:Int, val title : String? = null, val color: Int, val timestamp: Long)

data class Task(val id:Int, val content : String? = null, val timestamp: Long, val taskListId : Int, val isComplete: Boolean = false)

fun TaskEntity.toDomain() : Task {
    return Task(
        id = this.taskId,
        content = this.content,
        timestamp = this.timestamp,
        taskListId = this.taskListId
    )
}

fun TaskListEntity.toDomain() : TaskList {
    return TaskList(
        taskListId = this.taskListId,
        title = this.title,
        timestamp = this.timestamp,
        color = this.color
    )
}

fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        taskId = this.id,
        content = this.content!!,
        timestamp = this.timestamp,
        taskListId = this.taskListId,
        isComplete = this.isComplete
    )
}

fun TaskList.toEntity(): TaskListEntity {
    return TaskListEntity(
        taskListId = this.taskListId,
        title = this.title!!,
        timestamp = this.timestamp,
        color = this.color
    )
}