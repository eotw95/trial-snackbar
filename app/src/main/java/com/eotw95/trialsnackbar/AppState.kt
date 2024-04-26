package com.eotw95.trialsnackbar

import androidx.compose.material.ScaffoldState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AppState(
    val scaffoldState: ScaffoldState,
    val coroutineScope: CoroutineScope,
    snackbarManager: SnackbarManager = SnackbarManager
) {
    companion object {
        private const val Message1 = "message 1"
        private const val Message2 = "message 2"
        private const val Message3 = "message 3"
    }
    init {
        coroutineScope.launch {
            snackbarManager.messages.collect { newValue ->
                newValue?.let {
                    scaffoldState.snackbarHostState.showSnackbar(newValue)
                }
                snackbarManager.clearMessages()
            }
        }
    }

    fun showMessages() {
        coroutineScope.launch { SnackbarManager.showMessages(Message1) }
    }
}