package com.sp.cleanarchitectureapp.features.domain.repository

import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTasks(todoId: Int): Flow<List<Task>>

    suspend fun getTaskById(id: Int): Task?

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    fun getTaskList(): Flow<List<TaskList>>

    suspend fun getTaskListById(id: Int) : TaskList?

    suspend fun insertTaskList(taskList: TaskList)

    suspend fun deleteTaskList(taskList: TaskList)
}