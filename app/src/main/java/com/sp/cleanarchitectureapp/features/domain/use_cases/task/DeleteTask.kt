package com.sp.cleanarchitectureapp.features.domain.use_cases.task

import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository

class DeleteTask(private var repository: TodoRepository) {

    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}