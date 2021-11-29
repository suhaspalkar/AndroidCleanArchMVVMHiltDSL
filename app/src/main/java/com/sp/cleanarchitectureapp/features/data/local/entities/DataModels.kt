package com.sp.cleanarchitectureapp.features.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Task (
    @PrimaryKey val taskId: Int,
    val content : String,
    val timestamp: Long,
    val taskListId: Int,
    val isComplete: Boolean
)

@Entity
data class TaskList (
    @PrimaryKey val taskListId: Int,
    val title : String,
    val color:Int,
    val timestamp: Long
)
