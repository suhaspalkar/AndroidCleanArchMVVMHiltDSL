package com.sp.cleanarchitectureapp.features.domain.repository

import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTasks(): Flow<List<Task>>

    suspend fun getTaskById(id: Int): Task?

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    fun getTodos(): Flow<List<Todo>>

    suspend fun getTodoById(id: Int) : Todo?

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)
}