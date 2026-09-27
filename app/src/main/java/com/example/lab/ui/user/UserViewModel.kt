package com.example.lab.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab.data.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            try {
                val user = ApiClient.fetchUser()
                _state.value = if (user.email == GUEST_EMAIL) {
                    UiState.Empty
                } else {
                    UiState.Success(user)
                }
            } catch (e: Exception) {
                _state.value = UiState.Error("No se pudo cargar el usuario")
            }
        }
    }

    companion object {
        private const val GUEST_EMAIL = "guest@system.local"
    }
}
