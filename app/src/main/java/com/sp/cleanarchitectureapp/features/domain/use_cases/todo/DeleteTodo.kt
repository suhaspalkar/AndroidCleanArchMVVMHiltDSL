package com.sp.cleanarchitectureapp.features.domain.use_cases.todo

import com.sp.cleanarchitectureapp.features.domain.model.Todo
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository

class DeleteTodo(private var repository: TodoRepository) {

    suspend operator fun invoke(todo: Todo){
        repository.deleteTodo(todo)
    }

}
