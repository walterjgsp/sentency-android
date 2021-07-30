package org.wcode.sentency.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel
import org.wcode.sentency.domain.network.responses.QuoteResponse
import org.wcode.sentency.ui.screens.error.ErrorScreen
import org.wcode.sentency.ui.screens.home.components.AuthorView
import org.wcode.sentency.ui.screens.loading.LoadingScreen
import org.wcode.sentency.ui.shared.onError
import org.wcode.sentency.ui.shared.onLoading
import org.wcode.sentency.ui.shared.onSuccess
import org.wcode.sentency.ui.theme.Fonts
import org.wcode.sentency.ui.theme.SentencyColors

@Composable
fun HomeScreen() {
    val homeScreenViewModel = getViewModel<HomeScreenViewModel>()
    val uiState by homeScreenViewModel.state.collectAsState()
    uiState.onSuccess {
        HomeScreenContent(quoteResponse = it) {
            homeScreenViewModel.nextQuote()
        }
    }.onError {
        ErrorScreen()
    }.onLoading {
        LoadingScreen(message = "Quotes")
    }
}

@Composable
fun HomeScreenContent(quoteResponse: QuoteResponse, onNextClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = quoteResponse.messages[0].message,
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
            fontFamily = Fonts.sacramentoFamily
        )
        Spacer(modifier = Modifier.height(12.dp))
        AuthorView(quoteResponse.author)
        Spacer(modifier = Modifier.height(20.dp))
        FloatingActionButton(
            backgroundColor = SentencyColors.Purple500,
            onClick = onNextClicked,
        ) {
            Icon(Icons.Default.ArrowForward, "Next quote")
        }
    }
}