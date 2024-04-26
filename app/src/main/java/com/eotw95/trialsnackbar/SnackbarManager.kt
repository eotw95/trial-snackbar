package com.eotw95.trialsnackbar

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object SnackbarManager {
    private val _messages = MutableStateFlow<String?>(null)
    val messages: StateFlow<String?>
        get() = _messages

    fun showMessages(text: String) {
        _messages.value = text
    }
    fun clearMessages() { _messages.value = null }
}