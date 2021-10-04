package com.sp.cleanarchitectureapp.features.presentation.utils

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
    object SaveNote: UiEvent()
}