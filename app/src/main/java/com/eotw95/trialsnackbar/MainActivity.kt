package com.eotw95.trialsnackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.eotw95.trialsnackbar.ui.theme.TrialSnackbarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrialSnackbarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowSnackBar()
                }
            }
        }
    }
}

@Composable
fun ShowSnackBar() {
    val hostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = hostState)
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            Button(
                onClick = {
                    coroutineScope.launch { hostState.showSnackbar("sample text") }
                }
            ) {
                Text(text = "Show Snack bar")
            }
        }
    }
}