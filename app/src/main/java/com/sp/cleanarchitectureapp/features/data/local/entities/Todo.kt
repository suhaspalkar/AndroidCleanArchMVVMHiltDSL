package com.sp.cleanarchitectureapp.features.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    @PrimaryKey val id: Int? = null,
    val title : String? = null,
    val timestamp: Long)
