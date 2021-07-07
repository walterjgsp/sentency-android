package org.wcode.sentency.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel
import org.wcode.sentency.R
import org.wcode.sentency.ui.screens.splash.SplashScreenViewModel
import org.wcode.sentency.ui.theme.SentencyColors

@Composable
fun SplashScreen(navController: NavController) {
    val splashScreenViewModel = getViewModel<SplashScreenViewModel>()
    splashScreenViewModel.countdown(navController)
    SplashScreenContent()
}

@Preview()
@Composable
fun SplashScreenContent() {

    val animationTargetState = remember { mutableStateOf(0f) }

    val animatedFloatState = animateFloatAsState(
        targetValue = animationTargetState.value,
        animationSpec = tween(durationMillis = 3000)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SentencyColors.Purple700)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(animatedFloatState.value)
        ) {
            Box(
                modifier =
                Modifier
                    .align(Alignment.Center)
                    .background(Color.White, shape = CircleShape)
                    .size(130.dp, 130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    "Logo",
                    modifier = Modifier
                        .size(150.dp, 150.dp)
                        .align(Alignment.Center)
                        .clip(CircleShape)
                )
            }
        }
    }

    animationTargetState.value = 1f
}