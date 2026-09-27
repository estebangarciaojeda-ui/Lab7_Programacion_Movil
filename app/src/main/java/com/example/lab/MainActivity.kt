package com.example.lab

import androidx.compose.runtime.collectAsState
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.lab.ui.user.UserScreen
import com.example.lab.ui.user.UserViewModel

class MainActivity : ComponentActivity() {

    private val vm: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = vm.state.collectAsState().value
            UserScreen(state)
        }
    }
}
