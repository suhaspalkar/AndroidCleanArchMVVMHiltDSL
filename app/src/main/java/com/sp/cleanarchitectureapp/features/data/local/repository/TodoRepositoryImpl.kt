package com.sp.cleanarchitectureapp.features.data.local.repository

import com.sp.cleanarchitectureapp.features.data.local.data_source.daos.TaskDao
import com.sp.cleanarchitectureapp.features.data.local.data_source.daos.TodoDao
import com.sp.cleanarchitectureapp.features.data.local.entities.toDomain
import com.sp.cleanarchitectureapp.features.data.local.entities.toEntity
import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.model.Todo
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val todoDao: TodoDao,
    private val taskDao: TaskDao,

) : TodoRepository{

    override suspend fun deleteTask(task: Task) {
        return taskDao.deleteTask(task.toEntity())
    }

    override fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks().map {
            it.map { task ->
                task.toDomain()
            }
        }
    }

    override suspend fun getTaskById(id: Int): Task {
        return taskDao.getTaskById(id = id).toDomain()
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task = task.toEntity())
    }

    override fun getTodos(): Flow<List<Todo>> {
       return todoDao.getTodos().map {
            it.map { todo ->
                todo.toDomain()
            }
        }
    }

    override suspend fun insertTodo(todo: Todo) {
        todo.toEntity()?.let { todoDao.insertTodo(todo = it) }
    }

    override suspend fun deleteTodo(todo: Todo) {
        todo.toEntity()?.let { todoDao.deleteTodo(todo = it) }
    }

}


