package com.sp.cleanarchitectureapp.features.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Task (
    @PrimaryKey val id: Int? = null,
    val content : String? = null,
    val timestamp: Long,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val todoGroup : Todo? = null
)

