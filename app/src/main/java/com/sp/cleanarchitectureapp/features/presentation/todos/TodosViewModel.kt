package com.sp.cleanarchitectureapp.features.presentation.todos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sp.cleanarchitectureapp.features.domain.exception.InvalidTodoException
import com.sp.cleanarchitectureapp.features.domain.model.Todo
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
class TodosViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
    ) : ViewModel() {

    private val _todos = MutableLiveData<List<Todo>>()
    val todos = _todos

    private var getTodosJob: Job? = null
    private val _eventFlow = MutableSharedFlow<UiEvent>()

    fun getTodos() {
        getTodosJob?.cancel()
        getTodosJob = todoUseCases.getTodos()
            .onEach {
                _todos.value = it
            }
            .launchIn(viewModelScope)
    }

    fun addTodo(title: String?) {

        viewModelScope.launch {
            try {
                todoUseCases.addTodo(
                    Todo(
                        title = title,
                        timestamp = System.currentTimeMillis(),
                        id = _todos.value?.size ?: 1
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