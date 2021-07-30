package org.wcode.sentency.ui.screens.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(message: String) {
    LoadingScreenContent(message)
}

@Composable
fun LoadingScreenContent(message: String) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "Loading: $message",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}