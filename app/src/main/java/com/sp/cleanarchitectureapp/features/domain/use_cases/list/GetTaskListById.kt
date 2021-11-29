package com.sp.cleanarchitectureapp.features.domain.use_cases.list

import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository

class GetTaskListById(private var repository: TodoRepository) {

    suspend operator fun invoke(id: Int): TaskList? {
        return repository.getTaskListById(id)
    }

}
