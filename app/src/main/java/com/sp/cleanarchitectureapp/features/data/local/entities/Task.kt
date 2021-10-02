package com.sp.cleanarchitectureapp.features.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Task (
    @PrimaryKey val taskId: Int,
    val content : String,
    val timestamp: Long,
    val todoId: Int
)

