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

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task.toEntity())

    override fun getTasks(todoId: Int): Flow<List<Task>> = taskDao.getTasksByTodo(todoId).map {
        it.map { task ->
            task.toDomain()
        }
    }

    override suspend fun getTaskById(id: Int): Task? = taskDao.getTaskById(id = id)?.toDomain()

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task = task.toEntity())

    override fun getTodos(): Flow<List<Todo>> = todoDao.getTodos().map {
         it.map { todo ->
             todo.toDomain()
         }
     }

    override suspend fun getTodoById(id: Int): Todo? = todoDao.getTodoById(id)?.toDomain()

    override suspend fun insertTodo(todo: Todo) = todoDao.insertTodo(todo.toEntity())

    override suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo.toEntity())

}


