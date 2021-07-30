package org.wcode.sentency.ui.screens.error

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorScreen() {
    ErrorScreenContent()
}

@Composable
fun ErrorScreenContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Rounded.Warning, "Error icon",
            modifier = Modifier.size(50.dp),
            tint = Color.Red
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Error: Please try again!",
            textAlign = TextAlign.Center,
            color = Color.Red
        )
    }
}