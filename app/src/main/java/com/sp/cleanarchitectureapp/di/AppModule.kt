package com.sp.cleanarchitectureapp.di

import android.app.Application
import androidx.room.Room
import com.sp.cleanarchitectureapp.features.data.local.data_source.TodoDatabase
import com.sp.cleanarchitectureapp.features.data.local.repository.TodoRepositoryImpl
import com.sp.cleanarchitectureapp.features.domain.repository.TodoRepository
import com.sp.cleanarchitectureapp.features.domain.use_cases.*
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.AddTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.DeleteTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.GetTask
import com.sp.cleanarchitectureapp.features.domain.use_cases.task.GetTasks
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.AddTaskList
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.DeleteTaskList
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.GetTaskListById
import com.sp.cleanarchitectureapp.features.domain.use_cases.list.GetTaskList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(
            db.todoDao,
            db.taskDao
        )
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: TodoRepository): TodoUseCases {
        return TodoUseCases(
            getTaskList = GetTaskList(repository),
            deleteTaskList = DeleteTaskList(repository),
            addTaskList = AddTaskList(repository),
            getTaskListById = GetTaskListById(repository),

            getTasks = GetTasks(repository),
            deleteTask = DeleteTask(repository),
            addTask = AddTask(repository),
            getTask = GetTask(repository),
        )
    }
}