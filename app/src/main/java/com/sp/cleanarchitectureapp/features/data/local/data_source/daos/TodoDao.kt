package com.sp.cleanarchitectureapp.features.data.local.data_source.daos

import androidx.room.*
import com.sp.cleanarchitectureapp.features.data.local.entities.Task
import com.sp.cleanarchitectureapp.features.data.local.entities.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getTodos() : Flow<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Query("SELECT * FROM Todo WHERE todoId = :id")
    suspend fun getTodoById(id: Int) : Todo?

    @Delete
    suspend fun deleteTodo(todo: Todo)
}