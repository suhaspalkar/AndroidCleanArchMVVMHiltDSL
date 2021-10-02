package com.sp.cleanarchitectureapp.features.domain.use_cases.todo

import com.sp.cleanarchitectureapp.features.domain.model.Todo
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodos(private var repository: TodoRepository) {

    operator fun invoke(): Flow<List<Todo>> {
        return repository.getTodos()
    }

}
