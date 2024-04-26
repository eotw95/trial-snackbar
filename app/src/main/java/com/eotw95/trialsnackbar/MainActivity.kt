package com.eotw95.trialsnackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.eotw95.trialsnackbar.ui.theme.TrialSnackbarTheme
import kotlinx.coroutines.CoroutineScope

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
//    val hostState = remember { SnackbarHostState() }
//    val coroutineScope = rememberCoroutineScope()
    val state = rememberAppState()
    Scaffold(
        // Scaffold()の定義でsnackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
        // となっているので、ここで同じことを書く必要ない
//        snackbarHost = {
//            SnackbarHost(hostState = it)
//        },
        scaffoldState = state.scaffoldState
    ) {
        Surface(modifier = Modifier.padding(it)) {
            Button(
                onClick = state::showMessages
            ) {
                Text(text = "Show Snack bar")
            }
        }
    }
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, coroutineScope) {
        AppState(scaffoldState, coroutineScope)
    }