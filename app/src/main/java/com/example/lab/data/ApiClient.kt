package com.example.lab.data

import kotlinx.coroutines.delay

object ApiClient {

    // Simula una llamada de red
    suspend fun fetchUser(): User {
        delay(1500) // simula latencia
        return User.fromEmail("estudiante@puce.edu.ec")
    }
}
