package com.sp.cleanarchitectureapp.features.domain.use_cases.list

import com.sp.cleanarchitectureapp.features.domain.exception.InvalidTodoException
import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlin.jvm.Throws

class AddTaskList(private var repository: TodoRepository) {

    @Throws(InvalidTodoException::class)
    suspend operator fun invoke(taskList: TaskList){
        if (taskList.title.isNullOrBlank()){
            throw InvalidTodoException("The tile of the todo can't be empty.")
        }
        repository.insertTaskList(taskList)
    }

}
