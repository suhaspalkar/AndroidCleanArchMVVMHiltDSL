package com.sp.cleanarchitectureapp.features.domain.use_cases.task

import com.sp.cleanarchitectureapp.features.domain.exception.InvalidTaskException
import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlin.jvm.Throws

class AddTask(private var repository: TodoRepository) {

    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(task: Task){
        if (task.content.isNullOrBlank()){
            throw InvalidTaskException("The content of the task can't be empty.")
        }
        repository.insertTask(task)
    }

}
