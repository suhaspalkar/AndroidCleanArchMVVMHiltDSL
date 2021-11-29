package com.sp.cleanarchitectureapp.features.presentation.list.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sp.cleanarchitectureapp.features.domain.exception.InvalidTodoException
import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import com.sp.cleanarchitectureapp.features.domain.use_cases.TodoUseCases
import com.sp.cleanarchitectureapp.features.presentation.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddListViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
    ) : ViewModel() {

    private val _todos = MutableLiveData<List<TaskList>>()
    val todos = _todos

    private var getTodosJob: Job? = null
    private val _eventFlow = MutableSharedFlow<UiEvent>()

    fun getTodos() {
        getTodosJob?.cancel()
        getTodosJob = todoUseCases.getTaskList()
            .onEach {
                _todos.value = it
            }
            .launchIn(viewModelScope)
    }

    fun addTodo(id: Int?, title: String?, color: Int) {
        viewModelScope.launch {
            try {
                todoUseCases.addTaskList(
                    TaskList(
                        title = title,
                        timestamp = System.currentTimeMillis(),
                        color = color,
                        taskListId = id ?: 1

                    )
                )
                _eventFlow.emit(UiEvent.SaveNote)
            } catch (e: InvalidTodoException) {
                _eventFlow.emit(
                    UiEvent.ShowSnackbar(
                        message = e.message ?: "Couldn't save todo"
                    )
                )
            }
        }
    }


}