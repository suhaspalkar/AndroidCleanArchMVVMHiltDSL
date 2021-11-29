package com.sp.cleanarchitectureapp.features.domain.use_cases.list

import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository

class DeleteTaskList(private var repository: TodoRepository) {

    suspend operator fun invoke(taskList: TaskList){
        repository.deleteTaskList(taskList)
    }

}
