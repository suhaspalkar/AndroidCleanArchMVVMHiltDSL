package com.sp.cleanarchitectureapp.features.domain.use_cases.task

import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTasks(private var repository: TodoRepository) {

     operator fun invoke(todoId: Int): Flow<List<Task>> {
        return repository.getTasks(todoId)
    }

}