package com.sp.cleanarchitectureapp.features.data.local.data_source.daos

import androidx.room.*
import com.sp.cleanarchitectureapp.features.data.local.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task")
    fun getTasks() : Flow<List<Task>>

    @Query("SELECT * FROM Task WHERE taskId = :id")
    suspend fun getTaskById(id: Int) : Task?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

}