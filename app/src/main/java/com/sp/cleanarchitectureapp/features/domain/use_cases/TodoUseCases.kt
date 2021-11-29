package com.sp.cleanarchitectureapp.features.domain.use_cases

import com.sp.cleanarchitectureapp.features.domain.use_cases.task.AddTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.DeleteTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.GetTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.GetTasks
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.AddTaskList
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.DeleteTaskList
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.GetTaskListById
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.GetTaskList

class TodoUseCases(
    val getTaskList: GetTaskList,
    val deleteTaskList: DeleteTaskList,
    val addTaskList: AddTaskList,
    val getTaskListById: GetTaskListById,
    val getTasks: GetTasks,
    val deleteTask: DeleteTask,
    val addTask: AddTask,
    val getTask: GetTask
)
