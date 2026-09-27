package com.example.lab.ui.user

import com.example.lab.data.User

sealed class UiState {
    data object Loading : UiState()
    data class Success(val user: User) : UiState()
    data class Error(val message: String) : UiState()

    // Desafío extra: usuario invitado sin perfil
    data object Empty : UiState()
}
