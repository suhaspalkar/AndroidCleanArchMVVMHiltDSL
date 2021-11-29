package com.sp.cleanarchitectureapp.features.data.local.data_source.daos

import androidx.room.*
import com.sp.cleanarchitectureapp.features.data.local.entities.TaskList
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM TaskList")
    fun getTodos() : Flow<kotlin.collections.List<TaskList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(taskList: TaskList)

    @Query("SELECT * FROM TaskList WHERE taskListId = :id")
    suspend fun getTodoById(id: Int) : TaskList?

    @Delete
    suspend fun deleteTodo(taskList: TaskList)
}