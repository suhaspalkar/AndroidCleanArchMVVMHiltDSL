package com.sp.cleanarchitectureapp.features.domain.use_cases.todo

import com.sp.cleanarchitectureapp.features.domain.exception.InvalidTaskException
import com.sp.cleanarchitectureapp.features.domain.exception.InvalidTodoException
import com.sp.cleanarchitectureapp.features.domain.model.Todo
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlin.jvm.Throws

class AddTodo(private var repository: TodoRepository) {

    @Throws(InvalidTodoException::class)
    suspend operator fun invoke(todo: Todo){
        if (todo.title.isNullOrBlank()){
            throw InvalidTodoException("The tile of the todo can't be empty.")
        }
        repository.insertTodo(todo)
    }

}
