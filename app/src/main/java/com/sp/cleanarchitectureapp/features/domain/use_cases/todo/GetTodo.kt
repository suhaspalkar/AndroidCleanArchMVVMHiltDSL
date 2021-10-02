package com.sp.cleanarchitectureapp.features.domain.use_cases.todo

import com.sp.cleanarchitectureapp.features.domain.model.Todo
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository

class GetTodo(private var repository: TodoRepository) {

    suspend operator fun invoke(id: Int): Todo? {
        return repository.getTodoById(id)
    }

}
