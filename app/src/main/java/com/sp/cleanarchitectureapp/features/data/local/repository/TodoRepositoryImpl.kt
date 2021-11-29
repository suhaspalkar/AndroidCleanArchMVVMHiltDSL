package com.sp.cleanarchitectureapp.features.data.local.repository

import com.sp.cleanarchitectureapp.features.data.local.data_source.daos.TaskDao
import com.sp.cleanarchitectureapp.features.data.local.data_source.daos.TodoDao
import com.sp.cleanarchitectureapp.features.domain.model.Task
import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import com.sp.cleanarchitectureapp.features.domain.model.toEntity
import com.sp.cleanarchitectureapp.features.domain.model.toDomain
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val todoDao: TodoDao,
    private val taskDao: TaskDao,
    ) : TodoRepository {

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task.toEntity())

    override fun getTasks(todoId: Int): Flow<List<Task>> = taskDao.getTasksByTodo(todoId).map {
        it.map { task ->
            task.toDomain()
        }
    }

    override suspend fun getTaskById(id: Int): Task? = taskDao.getTaskById(id = id)?.toDomain()

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task = task.toEntity())

    override fun getTaskList(): Flow<List<TaskList>> = todoDao.getTodos().map {
        it.map { todo ->
            todo.toDomain()
        }
    }

    override suspend fun getTaskListById(id: Int): TaskList? = todoDao.getTodoById(id)?.toDomain()

    override suspend fun insertTaskList(taskList: TaskList) =
        todoDao.insertTodo(taskList.toEntity())

    override suspend fun deleteTaskList(taskList: TaskList) =
        todoDao.deleteTodo(taskList.toEntity())

}


