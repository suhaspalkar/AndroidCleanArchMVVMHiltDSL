package com.sp.cleanarchitectureapp.features.domain.model

data class Todo(val id:Int, val title : String? = null, val timestamp: Long)

data class Task(val id:Int, val content : String? = null, val timestamp: Long, val todo : Todo?)

