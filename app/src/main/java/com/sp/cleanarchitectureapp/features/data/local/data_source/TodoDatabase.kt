package com.sp.cleanarchitectureapp.features.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sp.cleanarchitectureapp.features.data.local.data_source.daos.TaskDao
import com.sp.cleanarchitectureapp.features.data.local.data_source.daos.TodoDao
import com.sp.cleanarchitectureapp.features.data.local.entities.Task
import com.sp.cleanarchitectureapp.features.data.local.entities.TaskList

@Database(
    entities = [TaskList::class, Task::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase: RoomDatabase() {

    abstract val todoDao: TodoDao
    abstract val taskDao: TaskDao

    companion object {
        const val DATABASE_NAME = "todos_db"
    }
}
