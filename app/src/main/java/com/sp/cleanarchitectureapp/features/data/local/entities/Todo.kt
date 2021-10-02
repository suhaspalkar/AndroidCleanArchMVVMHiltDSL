package com.sp.cleanarchitectureapp.features.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    @PrimaryKey val todoId: Int,
    val title : String,
    val timestamp: Long)
