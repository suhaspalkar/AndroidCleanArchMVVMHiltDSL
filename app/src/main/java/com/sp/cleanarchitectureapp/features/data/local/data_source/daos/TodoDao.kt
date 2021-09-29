package com.sp.cleanarchitectureapp.features.data.local.data_source.daos

import androidx.room.*
import com.sp.cleanarchitectureapp.features.data.local.entities.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getTodos() : Flow<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)
}