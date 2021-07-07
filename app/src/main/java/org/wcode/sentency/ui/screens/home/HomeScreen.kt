package org.wcode.sentency.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    HomeScreenContent()
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello Sentency", modifier = Modifier.align(Alignment.Center), fontSize = 20.sp)
    }
}