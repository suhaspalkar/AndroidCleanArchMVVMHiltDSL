package com.sp.cleanarchitectureapp.features.domain.use_cases.task

import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository

class GetTask(private var repository: TodoRepository) {

    suspend operator fun invoke(id: Int): Task? {
        return repository.getTaskById(id)
    }

}
