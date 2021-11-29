package com.sp.cleanarchitectureapp.features.domain.use_cases.list

import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTaskList(private var repository: TodoRepository) {

    operator fun invoke(): Flow<List<TaskList>> {
        return repository.getTaskList()
    }

}
