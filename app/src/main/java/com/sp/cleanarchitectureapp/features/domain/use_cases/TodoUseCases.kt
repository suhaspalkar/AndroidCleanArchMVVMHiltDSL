package com.sp.cleanarchitectureapp.features.domain.use_cases

import com.sp.cleanarchitectureapp.features.domain.use_cases.task.AddTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.DeleteTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.GetTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.GetTasks
import com.sp.cleanarchitectureapp.features.domain.use_cases.todo.AddTodo
import com.sp.cleanarchitectureapp.features.domain.use_cases.todo.DeleteTodo
import com.sp.cleanarchitectureapp.features.domain.use_cases.todo.GetTodo
import com.sp.cleanarchitectureapp.features.domain.use_cases.todo.GetTodos

class TodoUseCases(
    getTodos: GetTodos,
    deleteTodo: DeleteTodo,
    addTodo: AddTodo,
    getTodo: GetTodo,
    getTasks: GetTasks,
    deleteTask: DeleteTask,
    addTask: AddTask,
    getTask: GetTask
)
